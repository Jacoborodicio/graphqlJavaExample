package com.jr.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jr.model.Actor;
import com.jr.model.AddressInput;
import com.jr.repository.ActorRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ActorRepository repository;

    private ConcurrentHashMap<Integer, FluxSink<Actor>> subscribers = new ConcurrentHashMap<>();

    public List<Actor> getAllActors() {
        return repository.findAll();
    }

    public Actor getActorById(Integer id) {
        Optional<Actor> actor = repository.findById(id);
        return actor.orElseGet(actor::get);
    }

    @Transactional
    public Actor updateAddress(Integer id, String address) {
        Actor actor = repository.findById(id).get();
        actor.setAddress(address);
        repository.save(actor);
        return actor;
    }

    @Transactional
    public Actor updateAddressByObjectType(AddressInput input) {
        Actor actor = repository.findById(input.getActorId()).get();
        actor.setAddress(input.getAddress());
        repository.save(actor);

        if (subscribers.get(input.getActorId()) != null) {
            subscribers.get(input.getActorId()).next(actor);
        }
        return actor;
    }

    public Publisher<Actor> onActorUpdate(Integer actorId) {
         return Flux.create(subscriber -> subscribers.put(actorId, subscriber.onDispose(() -> subscribers.remove(actorId, subscriber))), FluxSink.OverflowStrategy.LATEST);
    }
}
