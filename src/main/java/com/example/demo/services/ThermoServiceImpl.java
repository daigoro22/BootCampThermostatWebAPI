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
    public List<ThermoInfo> getThermoinfos(Long devId) {
        return thermoRepository.findByDevId(devId);
    }

    @Override
    public ThermoInfo getThermoInfoById(Long devId,Long thermoInfoId) {
        List<ThermoInfo> thermoInfo = thermoRepository.findByDevIdAndThermoInfoId(devId,thermoInfoId);
        return thermoInfo.get(0);
    }

    @Override
    public ThermoInfo insertThermoInfo(Long devId,ThermoInfo thermoInfo) {
        if(thermoInfo.getTimestamp()==null){
            thermoInfo.setTimestamp(new Timestamp(System.currentTimeMillis()));
        }
        thermoInfo.setDevId(devId);
        return thermoRepository.save(thermoInfo);
    }

    @Override
    public void deleteThermoInfo(Long devId,Long id) {
        thermoRepository.deleteById(id);
    }
}
