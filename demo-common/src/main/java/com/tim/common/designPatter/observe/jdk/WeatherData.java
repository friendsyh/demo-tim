package com.tim.common.designPatter.observe.jdk;

import java.util.Observable;

/**
 * 天气数据对象，是一个主题，他的温度，湿度，气压等属性一旦有状态变化，会通知所有的观察者
 * 主题对象保存着状态，当这些状态变化的时候，通知观察者修改
 * @author tim.syh
 *
 */
public class WeatherData extends Observable{
	
	/** 温度 */
	private float temperature;

	/** 湿度 */
	private float humidity;

	/** 气压 */
	private float pressure;

	/** 状态变化的方法，只要调用这个方法，说明温度，湿度或者气压状态被修改。那么就发送消息  */
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		//注意多了一个setChange方法，只有调用了这个方法，才能发送消息，用来控制某些状态的变化其实是不需要发消息的情况。
		setChanged();
		notifyObservers();
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
