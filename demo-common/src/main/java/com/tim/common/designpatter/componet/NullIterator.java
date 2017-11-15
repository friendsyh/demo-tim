package com.tim.common.designpatter.componet;

import java.util.Iterator;

/**
 * Created by tim.syh on 2016/8/26.
 */
public class NullIterator implements Iterator{
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}
}
