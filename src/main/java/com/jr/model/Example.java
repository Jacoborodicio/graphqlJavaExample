package com.jr.model;

import javax.persistence.*;

@Entity
@Table(name = "EXAMPLE")
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer exampleId;

    @Column(name = "MSG")
    private String msg;

    public Example(){}
    public Example(String msg) {
        this.msg = msg;
    }

    public Integer getExampleId() {
        return exampleId;
    }

    public void setExampleId(Integer id) {
        this.exampleId = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
