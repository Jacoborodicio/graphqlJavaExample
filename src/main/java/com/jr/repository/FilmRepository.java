package com.jr.repository;

import com.jr.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FilmRepository extends JpaRepository<Film, Integer> {
}
