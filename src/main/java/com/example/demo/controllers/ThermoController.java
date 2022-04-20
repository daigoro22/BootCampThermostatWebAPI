package com.example.demo.controllers;

import com.example.demo.model.ThermoInfo;
import com.example.demo.services.ThermoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/temperature")
public class ThermoController {
    private final ThermoService thermoService;

    @Autowired
    public ThermoController(ThermoService todoService){
        this.thermoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<ThermoInfo>> getAllThermoinfos(@RequestParam("n") int n){
        return new ResponseEntity<>(thermoService.getThermoinfos(n), HttpStatus.OK);
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id){
        Todo todo = todoService.getTodoById(id);
        return todo != null ? new ResponseEntity<>(todo,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     */

    @PostMapping
    public ResponseEntity<ThermoInfo> saveThermoInfo(@RequestBody ThermoInfo thermoInfo){
        ThermoInfo newThermo = thermoService.inserThermoInfo(thermoInfo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("thermo","/api/v1/todo/"+newThermo.getId().toString());
        return new ResponseEntity<>(newThermo,httpHeaders,HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        Todo todoFromDb = todoService.getTodoById(id);
        if(todoFromDb!=null){
            todoService.updateTodo(id,todo);
        }
        return todoFromDb != null ? new ResponseEntity<>(todoService.getTodoById(id),HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<ThermoInfo> deleteThermoInfo(@PathVariable Long id){
        ThermoInfo thermoFromDb = thermoService.getThermoInfoById(id);
        if(thermoFromDb!=null){
            thermoService.deleteThermoInfo(id);
        }
        return thermoFromDb != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
