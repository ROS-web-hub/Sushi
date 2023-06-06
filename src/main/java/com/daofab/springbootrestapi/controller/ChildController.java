package com.daofab.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daofab.springbootrestapi.model.Child;
import com.daofab.springbootrestapi.service.IChildService;

@RestController
@RequestMapping("/api/child")
@CrossOrigin(origins = "*")
public class ChildController {
    
    @Autowired
    private IChildService childService;

    @RequestMapping("/all")
    public List<Child> findAll() {

        List<Child> childs = childService.findAll();

        return childs;
    }

    @RequestMapping("{id}")
    public ResponseEntity<Child> findById(@PathVariable(value="id") int id) {
        
        Child child = null;

        child = childService.findById(id);

        if(child != null) {
            return ResponseEntity.ok().body(child);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/parent/{id}")
    public List<Child> findByParentId(@PathVariable(value="id") int pId) {
        
        List<Child> list = childService.findsByParentId(pId);
        
        return list;
    }
}
