package com.jr.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jr.model.Actor;
import com.jr.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements GraphQLQueryResolver {

    @Autowired
    private ActorRepository repository;

    public List<Actor> getAllActors() {
        return repository.findAll();
    }
}
