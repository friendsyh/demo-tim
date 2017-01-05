package com.tim.common.designPatter.observe.headfirst;


/**
 * 目前状态的展示，观察者例子
 * @author tim.syh
 *
 */
public class CurrentConditionDisplay implements Observer, DisplayElment{
	
	/** 温度 */
	private float temperature;
	
	/** 湿度 */
	private float humidity;

	/** 这个引用没必要存在，因为注册进来是不需要这个引用的。但是留在这里的目的是以后方便把自己从主题中移除 */
	private Subject weatherData;

	/** 构造观察者的实现的时候，主题当中要注册这个观察者 */
	public CurrentConditionDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
	@Override
	public void display() {
		System.out.println("Current Condition:" + temperature + "degrees and " + humidity + "% humidity");
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

	public Subject getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(Subject weatherData) {
		this.weatherData = weatherData;
	}
	
}
