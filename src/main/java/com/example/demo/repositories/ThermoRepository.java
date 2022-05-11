package com.example.demo.repositories;

import com.example.demo.model.Device;
import com.example.demo.model.ThermoInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThermoRepository extends JpaRepository<ThermoInfo,Long> {
    List<ThermoInfo> findByDevice(Device device);
    List<ThermoInfo> findByDeviceAndThermoInfoId(Device device,Long thermoInfoId);
}