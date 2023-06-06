package com.daofab.springbootrestapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentList {
    List<Parent> data;

    public List<Parent> getData() {
        return data;
    }

    public void setData(List<Parent> data) {
        this.data = data;
    }
}
