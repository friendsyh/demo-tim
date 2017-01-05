package com.tim.common.designPatter.componet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tim.syh on 2016/8/26.
 */
public class CategoryParentDo implements ICategory{

	private int categoryId;

	private int parentId;

	private String categoryName;

	private List<ICategory> categoryList = new ArrayList<ICategory>();

	public CategoryParentDo(int categoryId, int parentId, String categoryName) {
		this.categoryId = categoryId;
		this.parentId = parentId;
		this.categoryName = categoryName;
	}

	@Override
	public List<? extends ICategory> getChildList() {
		return categoryList;
	}

	@Override
	public int getParentId() {
		return parentId;
	}

	@Override
	public boolean isRoot() {
		return categoryId == 0;
	}

	@Override
	public boolean hasChild() {
		return categoryList.size() > 0;
	}

	@Override
	public int getCategoryId() {
		return categoryId;
	}

	@Override
	public String getName() {
		return categoryName;
	}

	@Override
	public void add(ICategory category) {
		categoryList.add(category);
	}

	@Override
	public void remove(ICategory category) {
		categoryList.remove(category);
	}

	@Override
	public Iterator createIterator() {
		return new CategoryIterator(categoryList.iterator());
	}
}
