package com.daofab.springbootrestapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildList {
    List<Child> data;

    public List<Child> getData() {
        return data;
    }

    public void setData(List<Child> data) {
        this.data = data;
    }
}
