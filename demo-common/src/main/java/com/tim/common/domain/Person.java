package com.tim.common.domain;

import com.tim.common.pojo.BaseDO;

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
public class Person extends BaseDO {
	private String name;
	private int age;
}
