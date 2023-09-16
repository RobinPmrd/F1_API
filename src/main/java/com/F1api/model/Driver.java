package com.F1api.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @Column(name="driverid")
    private int id;
    @Column(name="driverref", length=255, nullable=false)
    private String driver_ref;
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
    private int highest_grid_position;
    @Transient
    private Integer highest_race_position;
	
    public int getId() {
		return id;
	}
	public String getDriverRef() {
		return driver_ref;
	}
	public Integer getNumber() {
		return number;
	}
	public String getCode() {
		return code;
	}
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
	public Date getDob() {
		return dob;
	}
	public String getNationality() {
		return nationality;
	}
	public String getUrl() {
		return url;
	}
	public int getTitles() {
		return titles;
	}
	public int getGrandprix() {
		return grandprix;
	}
	public int getWins() {
		return wins;
	}
	public int getPodiums() {
		return podiums;
	}
	public int getPoles() {
		return poles;
	}
	public int getHighestGridPosition() {
		return highest_grid_position;
	}
	public Integer getHighestRacePosition() {
		return highest_race_position;
	}
	public void setTitles(int titles) {
		this.titles = titles;
	}
	public void setGrandprix(int grandprix) {
		this.grandprix = grandprix;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public void setPoles(int poles) {
		this.poles = poles;
	}
	public void setPodiums(int podiums) {
		this.podiums = podiums;
	}
	public void setHighest_grid_position(int highest_grid_position) {
		this.highest_grid_position = highest_grid_position;
	}
	public void setHighest_race_position(Integer highest_race_position) {
		this.highest_race_position = highest_race_position;
	}
	
}