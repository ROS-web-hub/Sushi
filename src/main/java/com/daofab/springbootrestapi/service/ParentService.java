package com.daofab.springbootrestapi.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.daofab.springbootrestapi.model.Parent;
import com.daofab.springbootrestapi.model.ParentList;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ParentService implements IParentService {

    private String _mFileName = "Parent.json";

    @Override
    public List<Parent> findAll() {

        ParentList parents = new ParentList();
        parents = json2Object(_mFileName, ParentList.class);

        return parents.getData();
    }

    @Override
    public Parent findById(int id) {
        
        Parent parent = null;

        List<Parent> parents = this.findAll();

        for( int index = 0 ; index < parents.size() ; index ++ ) {
            if( parents.get(index).getId() == id ) {
                parent = parents.get(index);
                break;
            }
        }

        return parent;
    }

    public static <T>T json2Object(String fileName, Class<T> classType) {
        T t = null;

        File file = new File("src/main/resources/" + fileName);

        try {

            ObjectMapper mapper = new ObjectMapper();

            t = mapper.readValue(file, classType);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
    
}
