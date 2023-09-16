package com.F1api.model;

import java.sql.Date;
import java.sql.Time;

public interface RaceDTO {
	public int getId();
	public int getYear();
	public int getRound();
	public Circuit getCircuit();
	public String getName(); 
	public Date getDate();
	public Time getTime(); 
	public String getUrl(); 
	public String getWinner();
}
