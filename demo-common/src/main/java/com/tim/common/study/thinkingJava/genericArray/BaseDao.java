package com.tim.common.study.thinkingJava.genericArray;

//用泛型定义的接口。
public interface BaseDao<T> {
	public T getObject(T t);
	public void insert(T t);
}
