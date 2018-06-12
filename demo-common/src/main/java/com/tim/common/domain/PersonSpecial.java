package com.tim.common.domain;

import com.tim.common.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对象要想被序列化，必须实现Serializable接口
 * @author tim.syh
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSpecial extends BaseDO {
	private String name;
	private String age;
    private String others;

}
