package com.tim.common.designPatter.componet;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by tim.syh on 2016/8/26.
 */
public class CategoryIterator implements Iterator{

	Stack<Iterator> stack = new Stack<Iterator>();

	public CategoryIterator(Iterator iterator){
		stack.push(iterator);
	}

	@Override
	public boolean hasNext() {
		if(stack.isEmpty()){
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if(iterator.hasNext()){
				return true;
			} else {
				stack.pop();
				return hasNext();
			}
		}
	}

	@Override
	public Object next() {
		if(hasNext()){
			Iterator iterator = (Iterator) stack.peek();
			ICategory iCategory = (ICategory) iterator.next();
			if(iCategory instanceof CategoryParentDo){
				stack.push(iCategory.createIterator());
			}
			return iCategory;
		} else {
			return null;
		}
	}
}
