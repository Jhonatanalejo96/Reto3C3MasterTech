package Ciclo3.Reto3.services;

import Ciclo3.Reto3.model.Cabin;
import Ciclo3.Reto3.repository.RepositoryCabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesCabin {
    @Autowired
    private RepositoryCabin methodsCrud;

    public List<Cabin> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Cabin> getCabin(int cabinId) {
        return methodsCrud.getCabin(cabinId);
    }

    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return methodsCrud.save(cabin);
        }else{
            Optional<Cabin> e= methodsCrud.getCabin(cabin.getId());
            if(e.isEmpty()){
                return methodsCrud.save(cabin);
            }else{
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> e= methodsCrud.getCabin(cabin.getId());
            if(!e.isEmpty()){
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }


    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getCabin(cabinId).map(cabin -> {
            methodsCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
