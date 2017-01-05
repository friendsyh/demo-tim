package com.tim.common.study.thinkingJava.collection;

public class ArrayList {

	int index = 0;
	Object[] objects = new Object[10];
	public void add(Object o){
		if (index == objects.length) {
			Object[] newObjects = new Object[objects.length * 2];
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			objects = newObjects;
		}
		objects[index] = o;
		index++;
	}
	
	public int getSize(){
		return index;
	}
	
	public Object getIndex(int pos){
		if(pos >= 0 && pos < objects.length){
			return objects[pos];
		}else {
			return null;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		for(int i = 0;i < 15;i++){
			list.add(i * 2);
		}
		for(int i = 0;i < list.getSize();i++){
			System.out.println((Integer)list.getIndex(i));
		}
	}

}
