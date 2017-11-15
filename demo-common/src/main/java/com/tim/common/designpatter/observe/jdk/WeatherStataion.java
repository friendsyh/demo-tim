package com.tim.common.designpatter.observe.jdk;

/**
 * 使用观察者和主题的入口地方.
 * 一个气象站，如果检测到的气温，湿度，气压等指数有变化的时候，需要即时的展现出来。
 * @author tim.syh
 *
 */
public class WeatherStataion {
	
	public static void main(String[] args) {

		//创建主题
		WeatherData weatherData = new WeatherData();

		//创建多个观察者
		CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);
		StatisticsDisplay sDisplay = new StatisticsDisplay(weatherData);

		//执行顺序，发现变化，先通知所有的观察者修改
		weatherData.setMeasurements(25f, 50f, 30f);
		weatherData.setMeasurements(37f, 50f, 100f);
		weatherData.setMeasurements(80f, 50f, 100f);
	}
}
