package com.example.demo.repository;

import com.example.demo.interfaces.InterfaceCabin;
import com.example.demo.model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryCabin {
    @Autowired
    private InterfaceCabin crud;

    public List<Cabin> getAll(){
        return (List<Cabin>) crud.findAll();
    }

    public Optional<Cabin> getCabin(int cabinId){
        return crud.findById(cabinId);
    }

    public Cabin save(Cabin cabin){
        return crud.save(cabin);
    }
    public void delete(Cabin cabin){
        crud.delete(cabin);
    }
}
