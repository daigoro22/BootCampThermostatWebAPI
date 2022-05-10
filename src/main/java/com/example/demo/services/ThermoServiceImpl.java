package com.example.demo.services;

import com.example.demo.model.Device;
import com.example.demo.model.ThermoInfo;
import com.example.demo.repositories.DeviceRepository;
import com.example.demo.repositories.ThermoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ThermoRepository thermoRepository;
    @Autowired
    DeviceRepository deviceRepository;

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
        Device device = new Device();
        device.setDevId(devId);
        return thermoRepository.findByDevice(device);
    }

    @Override
    public List<ThermoInfo> getAllThermoInfos() {
        return thermoRepository.findAll();
    }

    @Override
    public ThermoInfo getThermoInfoById(Long devId,Long thermoInfoId) {
        Device device = new Device();
        device.setDevId(devId);
        List<ThermoInfo> thermoInfo = thermoRepository.findByDeviceAndThermoInfoId(device,thermoInfoId);
        return thermoInfo.get(0);
    }

    @Override
    public ThermoInfo insertThermoInfo(Long devId,ThermoInfo thermoInfo) {
        if(thermoInfo.getTimestamp()==null){
            thermoInfo.setTimestamp(new Timestamp(System.currentTimeMillis()));
        }

        Device device = deviceRepository.findDeviceByDevId(devId);

        if(device==null) {
            device = new Device();
            device.setDevId(devId);
            deviceRepository.saveAndFlush(device);
        }

        thermoInfo.setDevice(device);
        return thermoRepository.save(thermoInfo);
    }

    @Override
    public void deleteThermoInfo(Long devId,Long id) {
        thermoRepository.deleteById(id);
    }
}
