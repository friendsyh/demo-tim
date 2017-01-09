/**
 * 
 */
package com.tim.common.practice.framworkdemo;
public class Student {
	
//	public void learnBookA() {
//		IBook book = new BookA();
//		book.learn();
//	}
//	
//	public void learnBookB() {
//		IBook book = new BookB();
//		book.learn();
//	}
//	public static void main(String[] args) {
//		Student student = new Student();
//		student.learnBookA();
//		student.learnBookB();
//	}
	
/*----------------------------------------------------------------------------*/	
//	public void learnBookA() {
//		BookFactory.getBookA().learn();
//	}
//	
//	public void learnBookB() {
//		BookFactory.getBookB().learn();
//	}
//	
//	public static void main(String[] args) {
//		Student student = new Student();
//		student.learnBookA();
//		student.learnBookB(); c
//	}

/*----------------------------------------------------------------------------*/	
	
	public void learnBook(IBook book) {
		book.learn();
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Student student = (Student) Class.forName("Student").newInstance();
		student.learnBook(new BookA());
		student.learnBook(new BookB());
		
	}
}
