package entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sportexterieur extends Sport {
	
	private double temperatureMax;
	private double temperatureMin;
		
	public double getTemperatureMax() {
		return temperatureMax;
	}
	
	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	
	
	public double getTemperatureMin() {
		return temperatureMin;
	}
	
	
	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	
	

}
