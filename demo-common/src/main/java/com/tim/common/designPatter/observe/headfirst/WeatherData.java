package com.tim.common.designPatter.observe.headfirst;

import java.util.ArrayList;

/**
 * 天气数据对象，是一个主题，他的温度，湿度，气压等属性一旦有状态变化，会通知所有的观察者
 * 主题对象保存着状态，当这些状态变化的时候，通知观察者修改
 * @author tim.syh
 *
 */
public class WeatherData implements Subject{
	
	/** 观察者容器  */
	private ArrayList<Observer> observers;
	
	/** 温度 */
	private float temperature;
	
	/** 湿度 */
	private float humidity;
	
	/** 气压 */
	private float pressure;
	
	/**
	 * 状态变化的方法，只要调用这个方法，说明温度，湿度或者气压状态被修改。那么就发送消息
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObsevers();
	}
	
	public WeatherData(){
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObsevers() {
		for(Observer o : observers){
			o.update(temperature, humidity, pressure);
		}
	}
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	
}
