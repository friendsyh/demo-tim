package com.tim.common.designPatter.observe.jdk;


import java.util.Observable;
import java.util.Observer;

/**
 * 目前状态的平均值
 * @author tim.syh
 *
 */
public class StatisticsDisplay implements Observer, DisplayElment {

	private float temperature;
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private Observable observable;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof  WeatherData){
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			tempSum += temperature;
			numReadings++;
			if (temperature > maxTemp) {
				maxTemp = temperature;
			}
			if (temperature < minTemp) {
				minTemp = temperature;
			}
			display();
		}
	}

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}

}
