package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Rentar;
import com.example.demo.models.entity.pk.RentarPK;

public interface IRentarDao extends CrudRepository<Rentar, Long> {

}
