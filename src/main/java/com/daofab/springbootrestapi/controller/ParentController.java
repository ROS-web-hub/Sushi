package com.daofab.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daofab.springbootrestapi.model.Parent;
import com.daofab.springbootrestapi.service.IParentService;

@RestController
@RequestMapping("/api/parent")
@CrossOrigin(origins = "*")
public class ParentController {
    
    @Autowired
    private IParentService parentService;

    @RequestMapping("/all")
    public List<Parent> findAll() {

        List<Parent> parents = parentService.findAll();

        return parents;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Parent> findById(@PathVariable(value="id") int id) {
        
        Parent parent = null;

        parent = parentService.findById(id);

        if(parent != null) {
            return ResponseEntity.ok().body(parent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
