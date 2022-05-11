package com.example.demo.controllers;

import com.example.demo.model.ThermoInfo;
import com.example.demo.services.ThermoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://editor.swagger.io/")
@RestController
@RequestMapping("/api/v2/temperature")
public class ThermoController {
    private final ThermoService thermoService;

    @Autowired
    public ThermoController(ThermoService todoService){
        this.thermoService = todoService;
    }

    @GetMapping("/{devId}")
    public ResponseEntity<List<ThermoInfo>> getAllThermoinfos(@PathVariable Long devId) {
        return new ResponseEntity<>(thermoService.getThermoinfos(devId), HttpStatus.OK);
    }

    @PostMapping("/{devId}")
    public ResponseEntity<ThermoInfo> saveThermoInfo(@PathVariable Long devId,@RequestBody ThermoInfo thermoInfo) {
        ThermoInfo newThermo = thermoService.insertThermoInfo(devId,thermoInfo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("thermo", "/api/v2/temperature/" + newThermo.getDevice().getDevId().toString() + "/"
                + newThermo.getThermoInfoId().toString());return new ResponseEntity<>(newThermo, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{devId}/{thermoInfoId}")
    public ResponseEntity<ThermoInfo> deleteThermoInfo(@PathVariable Long devId,@PathVariable Long thermoInfoId){
        ThermoInfo thermoFromDb = thermoService.getThermoInfoById(devId,thermoInfoId);
        if(thermoFromDb!=null){
            thermoService.deleteThermoInfo(devId,thermoInfoId);
        }
        return thermoFromDb != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

