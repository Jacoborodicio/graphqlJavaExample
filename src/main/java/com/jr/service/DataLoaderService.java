package com.jr.service;

import com.jr.model.Actor;
import com.jr.model.Film;
import com.jr.repository.ActorRepository;
import com.jr.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DataLoaderService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmRepository filmRepository;

    @PostConstruct
    public void loadData() {
        String [] actors = {"Marlon Brando", "Angelina Joly", "Brad Pit", "Alicia Keys"};
        Map<String, String> films = new HashMap<String, String>() {
            {
                put("Marlon Brando", "El Padrino");
                put("Angelina Joly", "Lara Croft");
                put("Brad Pit", "Titanic");
                put("Alicia Keys", "We are together");
            }
        };
        for (String actorName :actors) {
            String [] names = actorName.split(" ");
            Date dateOfBirth = DataLoaderService.between(new Date(1960, Calendar.JANUARY, 1), new Date(1980, Calendar.JANUARY, 1));
            Date dateOfLaunch = DataLoaderService.between(new Date(1990, Calendar.JANUARY, 1), new Date(2021, Calendar.JANUARY, 1));
            Film film = new Film(films.get(actorName), dateOfLaunch);
            filmRepository.save(film);
            Actor actor = new Actor(names[0], names[1], dateOfBirth, "Unknown Country", film.getFilmId());
            actorRepository.save(actor);
        }
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
        return new Date(randomMillisSinceEpoch);
    }
}
