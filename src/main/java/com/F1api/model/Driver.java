package com.F1api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @Column(name="driver_id")
    private int id;
    @Column(name="driver_ref", length=255, nullable=false)
    private String driverRef;
    @Column(name="number", nullable=true)
    private Integer number;
    @Column(name="code", length=255, nullable=true)
    private String code;
    @Column(name="forename", length=255, nullable=false)
    private String forename;
    @Column(name="surname", length=255, nullable=false)
    private String surname;
    @Column(name="dob")
    private Date dob;
    @Column(name="nationality", length=255, nullable=false)
    private String nationality;
    @Column(name="url", length=255, nullable=false)
    private String url;
    @Transient
    private int titles;
    @Transient
    private int grandprix;
    @Transient
    private int wins;
    @Transient
    private int podiums;
    @Transient
    private int poles;
    @Transient
    private int highestGridPosition;
    @Transient
    private Integer highestRacePosition;
    @Transient
    private String seasons;

}