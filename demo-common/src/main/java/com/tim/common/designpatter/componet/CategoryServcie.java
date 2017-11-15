package com.tim.common.designpatter.componet;

/**
 * Created by tim.syh on 2016/8/26.
 */
public interface CategoryServcie {
	public ICategory getRootCategory();

	public ICategory getCategoryById(int categoryId);
}
