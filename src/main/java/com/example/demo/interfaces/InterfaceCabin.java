package com.example.demo.interfaces;

import com.example.demo.model.Cabin;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCabin extends CrudRepository<Cabin,Integer> {
}
