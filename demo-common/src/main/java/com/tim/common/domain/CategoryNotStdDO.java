package com.tim.common.domain;

import com.tim.common.domain.test.FeatureDO;
import com.tim.common.domain.test.FeatureResultDO;
import com.tim.common.pojo.BaseDO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by tim.syh on 2016/8/26.
 */
@Data
@AllArgsConstructor
public class CategoryNotStdDO extends BaseDO{

	private int category_id;

	private boolean is_parent;

	private String category_name;

	private FeatureDO feature_do;

	private List<FeatureDO> feature_dos;

	private FeatureResultDO material_do;
}
