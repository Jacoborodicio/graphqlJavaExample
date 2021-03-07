package com.jr.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jr.model.Actor;
import com.jr.model.AddressInput;
import com.jr.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ActorRepository repository;

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
        return actor;
    }
}
