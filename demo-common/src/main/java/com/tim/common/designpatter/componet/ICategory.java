package com.tim.common.designpatter.componet;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tim.syh on 2016/8/26.
 */
public interface ICategory {

	List<? extends ICategory> getChildList();

	int getParentId();

	boolean isRoot();

	boolean hasChild();

	int getCategoryId();

	String getName();

    void add(ICategory category);

	void remove(ICategory category);

	Iterator createIterator();
}
