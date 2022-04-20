package com.example.demo.services;

import com.example.demo.model.ThermoInfo;

import java.util.List;

public interface ThermoService {
    List<ThermoInfo> getThermoinfos(int n);

    ThermoInfo getThermoInfoById(Long id);
    ThermoInfo inserThermoInfo(ThermoInfo thermoInfo);
    void deleteThermoInfo(Long id);
}
