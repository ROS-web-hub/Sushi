package com.daofab.springbootrestapi.service;

import java.util.List;

import com.daofab.springbootrestapi.model.Child;

public interface IChildService {
    
    List<Child> findAll();

    Child findById(int id);

    List<Child> findsByParentId(int pId);
}
