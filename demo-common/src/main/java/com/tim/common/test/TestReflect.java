package com.tim.common.test;

import com.tim.common.test.IO.Student;
import com.tim.common.test.IO.BookA;

public class TestReflect {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			Student student = (Student) Class.forName("Student").newInstance();
			student.learnBook(new BookA());
	}
}
