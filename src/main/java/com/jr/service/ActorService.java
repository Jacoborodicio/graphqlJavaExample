package com.jr.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jr.model.Actor;
import com.jr.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService implements GraphQLQueryResolver {

    @Autowired
    private ActorRepository repository;

    public List<Actor> getAllActors() {
        return repository.findAll();
    }

    public Actor getActorById(Integer id) {
        Optional<Actor> actor = repository.findById(id);
        return actor.orElseGet(actor::get);
    }
}
