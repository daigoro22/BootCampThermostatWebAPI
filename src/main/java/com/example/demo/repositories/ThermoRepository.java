package com.example.demo.repositories;

import com.example.demo.model.ThermoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThermoRepository extends JpaRepository<ThermoInfo,Long> {
    List<ThermoInfo> findByDevId(Long devId);
    List<ThermoInfo> findByDevIdAndThermoInfoId(Long devId,Long thermoInfoId);
}