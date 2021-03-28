package com.jr.repository;

import com.jr.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ExampleRepository extends JpaRepository<Example, Integer> {
}
