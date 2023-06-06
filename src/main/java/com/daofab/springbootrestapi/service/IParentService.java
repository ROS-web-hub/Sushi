package com.daofab.springbootrestapi.service;

import java.util.List;

import com.daofab.springbootrestapi.model.Parent;

public interface IParentService {
    
    List<Parent> findAll();

    Parent findById(int _id);

}
