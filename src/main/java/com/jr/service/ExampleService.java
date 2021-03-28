package com.jr.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jr.model.Example;
import com.jr.model.ExampleInput;
import com.jr.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExampleService implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private ExampleRepository exampleRepository;

    public List<Example> getAllExamples() {
        return exampleRepository.findAll();
    }

    public Example getExampleById(Integer id) {
        return exampleRepository.findById(id).get();
    }

    @Transactional
    public Example updateMsg(String msg, Integer id) {
        Example example = exampleRepository.findById(id).get();
        example.setMsg(msg);
        exampleRepository.save(example);
        return example;
    }

    @Transactional
    public Example updateMsgByObjectType(ExampleInput exampleObj) {
        Example example = exampleRepository.findById(exampleObj.getExampleId()).get();
        example.setMsg(exampleObj.getMsg());
        exampleRepository.save(example);
        return example;
    }
}
