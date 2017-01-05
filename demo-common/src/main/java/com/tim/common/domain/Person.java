package com.tim.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 对象要想被序列化，必须实现Serializable接口
 * @author tim.syh
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{
	
	private static final long serialVersionUID = -7142264207488774373L;

	private String name;
	private int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
