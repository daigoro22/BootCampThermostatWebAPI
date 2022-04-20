package com.example.demo.repositories;

import com.example.demo.model.ThermoInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThermoRepository extends CrudRepository<ThermoInfo,Long> { //TODO: JpaRepository に変更

}
