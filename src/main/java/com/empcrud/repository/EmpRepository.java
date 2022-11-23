package com.empcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empcrud.model.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Integer>{

}
