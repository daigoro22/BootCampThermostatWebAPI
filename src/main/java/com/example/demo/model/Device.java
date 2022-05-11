package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column//(updatable = false,nullable = false)
    Long devId;

    @OneToMany(mappedBy = "device",cascade = CascadeType.ALL)
    private List<ThermoInfo> thermoInfoList;

    @Column
    double longitude;

    @Column
    double latitude;
}
