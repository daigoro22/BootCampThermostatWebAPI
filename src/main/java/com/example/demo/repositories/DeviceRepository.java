package com.example.demo.repositories;

import com.example.demo.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
    Device findDeviceByDevId(Long devId);
}