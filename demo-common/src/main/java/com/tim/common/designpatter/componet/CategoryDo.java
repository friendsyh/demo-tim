package com.tim.common.designpatter.componet;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tim.syh on 2016/8/26.
 */
public class CategoryDo implements ICategory{

	private int categoryId;

	private int parentId;

	private String categoryName;

	public CategoryDo(int categoryId, int parentId, String categoryName) {
		this.categoryId = categoryId;
		this.parentId = parentId;
		this.categoryName = categoryName;
	}

	@Override
	public List<? extends ICategory> getChildList() {
		return null;
	}

	@Override
	public int getParentId() {
		return parentId;
	}

	@Override
	public boolean isRoot() {
		return false;
	}

	@Override
	public boolean hasChild() {
		return false;
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

	}

	@Override
	public void remove(ICategory category) {

	}

	@Override
	public Iterator createIterator() {
		return new NullIterator();
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
