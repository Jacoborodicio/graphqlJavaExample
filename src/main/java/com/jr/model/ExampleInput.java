package com.jr.model;

import graphql.schema.GraphQLInputType;

public class ExampleInput implements GraphQLInputType {
    private Integer exampleId;
    private String msg;

    @Override
    public String getName() {return "msgUpdate";}

    public Integer getExampleId() {
        return exampleId;
    }

    public void setExampleId(Integer exampleId) {
        this.exampleId = exampleId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
