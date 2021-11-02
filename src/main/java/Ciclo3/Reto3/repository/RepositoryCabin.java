package Ciclo3.Reto3.repository;

import Ciclo3.Reto3.interfaces.InterfaceCabin;
import Ciclo3.Reto3.model.Cabin;
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

    public Optional<Cabin> getCabin(int id){
        return crud.findById(id);
    }

    public Cabin save(Cabin cabin){
        return crud.save(cabin);
    }
    public void delete(Cabin cabin){
        crud.delete(cabin);
    }
}
