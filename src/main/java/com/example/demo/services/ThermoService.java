package com.example.demo.services;

import com.example.demo.model.ThermoInfo;

import java.util.List;

public interface ThermoService {
    List<ThermoInfo> getThermoinfos(Long devId);

    List<ThermoInfo> getAllThermoInfos();

    ThermoInfo getThermoInfoById(Long devId, Long id);
    ThermoInfo insertThermoInfo(Long devId,ThermoInfo thermoInfo);
    void deleteThermoInfo(Long devId,Long id);
}
