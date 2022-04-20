package com.example.demo.services;

import com.example.demo.model.ThermoInfo;
import com.example.demo.repositories.ThermoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ThermoServiceImpl implements ThermoService {
    ThermoRepository thermoRepository;

    public ThermoServiceImpl(ThermoRepository todoRepository){
        this.thermoRepository = todoRepository;
    }

    /*
    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Todo todoFromDb = todoRepository.findById(id).get();
        todoFromDb.setTitle(todo.getTitle());
        todoFromDb.setDescription(todo.getDescription());
        todoFromDb.setTodoStatus(todo.getTodoStatus());
        return todoRepository.save(todoFromDb);
    }
    */

    @Override
    public List<ThermoInfo> getThermoinfos(int n) {
        List<ThermoInfo> thermos = new ArrayList<>();
        thermoRepository.findAll().forEach(thermos::add);
        int fromIndex = (thermos.size()-n>0)?thermos.size()-n:0;
        return thermos.subList(fromIndex,thermos.size());
    }

    @Override
    public ThermoInfo getThermoInfoById(Long id) {
        Optional<ThermoInfo> thermoInfo = thermoRepository.findById(id);
        return thermoInfo.orElse(null);
    }

    @Override
    public ThermoInfo inserThermoInfo(ThermoInfo thermoInfo) {
        return thermoRepository.save(thermoInfo);
    }

    @Override
    public void deleteThermoInfo(Long id) {
        thermoRepository.deleteById(id);
    }
}
