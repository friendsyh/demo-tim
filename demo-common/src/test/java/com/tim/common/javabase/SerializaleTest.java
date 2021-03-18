package com.tim.common.javabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.tim.common.domain.Person;

/**
 * 序列化测试
 */
public class SerializaleTest {

	public static void main(String[] args) throws Exception{
		//定义一个person对象
		Person person = new Person("tim", 20);
		//序列化对象到path目录下，可以看到执行完成之后在D:/temp目录下多了一个person.txt文件
		String path = "D:/temp/person.txt";
		serialiobject(person, path);
		
		//执行完上面的之后，你可以关闭掉eclipse甚至跑到你隔壁的电脑去执行反序列化的代码
		//当然如果你要去隔壁电脑执行，需要把person.txt文件也拷贝过去哈
		Person p = deSerialiobject("D:/temp/person.txt");
		//打印下结果是 :Person [name=tim, age=20],perosn的信息又回来了。
		System.out.println(p);
	}

	/**
	 * 序列化Person对象，生成的字节流存放path目录下去
	 * @param person
	 */
	private static void serialiobject(Person person, String path) throws Exception{
		//jdk自带的序列化类，把person对象写入到path目录下的文件中
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(path));
		oo.writeObject(person);
		oo.close();
		System.out.println("对象序列化成功");
	}
	
	/**
	 * 从文件中去读取对象。
	 * @param path 已经序列化的文件的目录
	 * @return Person对象
	 */
	private static Person deSerialiobject(String path) throws Exception{
		//jdk自带的反序列化类，又把path路径下文件的内容读回成一个对象
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path));
		Person p = (Person)oi.readObject();
		oi.close();
		System.out.println("对象反序列化成功！");
		return p;
	}
}
