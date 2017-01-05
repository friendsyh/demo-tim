package com.tim.common.designPatter.observe.jdk;


import java.util.Observable;
import java.util.Observer;

/**
 * 目前状态的展示，观察者例子
 * @author tim.syh
 *
 */
class CurrentConditionDisplay implements Observer, DisplayElment {

	/** 温度 */
	private float temperature;

	/** 湿度 */
	private float humidity;

	private Observable observable;

	/** 构造观察者的实现的时候，主题当中要注册这个观察者 */
	public CurrentConditionDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherData){
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Current Condition:" + temperature + "degrees and " + humidity + "% humidity");
	}
}
