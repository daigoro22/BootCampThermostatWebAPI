package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"device"})
public class ThermoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    Long thermoInfoId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="dev_id")
    private Device device;

    @Column(updatable = false)
    Timestamp timestamp;

    @Column
    double degree;

    @Column
    DegreeType degreeType;
}
