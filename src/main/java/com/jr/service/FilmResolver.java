package com.jr.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.jr.model.Actor;
import com.jr.model.Film;
import com.jr.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FilmResolver implements GraphQLResolver<Actor> {
    @Autowired
    private FilmRepository filmRepository;

    @Transactional
    public Film getFilm(Actor actor) {
        return filmRepository.findById(actor.getFilmId()).get();
    }
}
