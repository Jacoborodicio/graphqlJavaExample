package com.jr.model;

import graphql.schema.GraphQLInputType;

public class AddressInput implements GraphQLInputType {
    private Integer actorId;
    private String address;

    @Override
    public String getName() {
        return "addressUpdate";
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
