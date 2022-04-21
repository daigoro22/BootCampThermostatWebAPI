package com.example.demo.services;

import com.example.demo.model.ThermoInfo;
import com.example.demo.repositories.ThermoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

        Page<ThermoInfo> page = thermoRepository.findAll(
                PageRequest.of(0,n, Sort.by(Sort.Direction.ASC,"id"))
        );

        return page.stream().toList();
    }

    @Override
    public ThermoInfo getThermoInfoById(Long id) {
        Optional<ThermoInfo> thermoInfo = thermoRepository.findById(id);
        return thermoInfo.orElse(null);
    }

    @Override
    public ThermoInfo inserThermoInfo(ThermoInfo thermoInfo) {
        if(thermoInfo.getTimestamp()==null){
            thermoInfo.setTimestamp(new Timestamp(System.currentTimeMillis()));
        }
        return thermoRepository.save(thermoInfo);
    }

    @Override
    public void deleteThermoInfo(Long id) {
        thermoRepository.deleteById(id);
    }
}
