package com.tim.common.designpatter.componet;

import java.util.Iterator;

/**
 * Created by tim.syh on 2016/8/26.
 */
public class CategoryServiceImpl implements CategoryServcie{

	/** 基本的数据源 */
	private ICategory iCategory;

	public CategoryServiceImpl(ICategory iCategory){
		this.iCategory = iCategory;
	}

	/**
	 * id为0就是根节点
	 * @return
	 */
	@Override
	public ICategory getRootCategory() {
		return getCategoryById(0);
	}

	@Override
	public ICategory getCategoryById(int categoryId) {
		Iterator iterator = iCategory.createIterator();
		while(iterator.hasNext()){
			iCategory = (ICategory)iterator.next();
			if(iCategory != null && iCategory.getCategoryId() == categoryId){
				return iCategory;
			}
		}
		return null;
	}
}
