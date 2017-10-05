package com.tim.common.designPatter.factory.simplefactory;

/**
 * Created by tim.syh on 2016/8/30.
 */
public interface Pizza {

	/** 准备 */
	public void prepare();

	/** 烘烤 */
	public void bake();

	/** 打包 */
	public void pack();
}
