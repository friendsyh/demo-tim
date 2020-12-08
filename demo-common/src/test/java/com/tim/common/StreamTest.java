package com.tim.common;

import com.tim.common.domain.Person;
import com.tim.common.domain.Student;
import com.tim.common.pojo.InitTestData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 集合Stream各种测试
 * Created by tim.syh on 2017/1/8.
 */
public class StreamTest extends InitTestData {

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void testSorted() throws Exception {
        //用stream流这样写有问题，排好序了，但是返回的是一个流。不行
        testStringList.stream().sorted();

        //默认为升序排序
        List<String> rlt1 = testStringList.stream().sorted().collect(Collectors.toList());
        //降序排序
        List<String> rlt2 = testStringList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        //对象排序。默认按照对象toString方法升序排序
        List<Student> rlt3 = testStudentList.stream().sorted().collect(Collectors.toList());
        //按照年龄降序排列
        List<Student> rlt4 = testStudentList.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        //先按照年龄降序，再按照学校升序(一)。推荐这种写法吧,比起下面这种写法简单很多
        List<Student> rlt5 =
                testStudentList.stream().sorted(Comparator.comparing(Student::getAge).reversed().thenComparing(Comparator.comparing(Student::getSchoolName).reversed())).collect(Collectors.toList());
        //先按照年龄降序，在按照学校升序(二)
        List<Student> rlt6 =
                testStudentList.stream().sorted(Comparator.comparing(Student::getAge, Comparator.reverseOrder()).thenComparing(Comparator.comparing(Student::getSchoolName, Comparator.reverseOrder()))).collect(Collectors.toList());

        System.out.println("OK");
    }


    @Test
    public void testStreamMap() throws Exception {
        //map就是转换。1对1的转换，所有转成大写
        List<String> rlt2 = testStringList.stream().map(String::toUpperCase).collect(Collectors.toList());

        //把对象的schoolName属性抽取出来组成一个List(未去重)
        List<String> rlt3 = testStudentList.stream().map(Student::getSchoolName).collect(Collectors.toList());
        //把对象的schoolName属性抽取出来组成一个List(去重)
        List<String> rlt4 = testStudentList.stream().map(Student::getSchoolName).distinct().collect(Collectors.toList());

        //把对象的年龄都*2
        //这种写法编译报错，不能直接去修改对象
//        List<Student> rlt10 = testStudentList.stream().map(p -> p.setAge(p.getAge() * 2)).collect(Collectors.toList());
        //修改之后需要return才是对的。【用这种方式修改了之后testStudentList也会age*2。说明是在原来对象上修改】
        List<Student> rlt11 = testStudentList.stream().map(p -> { p.setAge(p.getAge() * 2); return p; }).collect(Collectors.toList());
        //或者把p修改为一个新的对象【用这种方式修改了之后testStudentList不会age*2,是生成了新的对象】
        List<Student> rlt12 =
                testStudentList.stream().map(p -> new Student(p.getName(), p.getAge() * 2, p.getSchoolName())).collect(Collectors.toList());
        //直接修改属性的值
        testStudentList.forEach(p -> p.setAge(p.getAge() * 2));

        System.out.println("OK");
    }

    @Test
    public void testStreamReduce() throws Exception {
        //先过滤，然后转为map. key=schoolName,value=Student
//        Map<String, Student> rlt1 = testStudentList.stream().filter(item -> item.getAge() > 10).collect(Collectors.toMap(Student::getSchoolName,
//                item -> item)); //如果有重复的key会报错
        //过滤再转成map,会把重复的key的对象丢弃掉
        Map<String, Student> rlt2 = testStudentList.stream().filter(item -> item.getAge() > 10).collect(Collectors.toMap(Student::getSchoolName,
                a -> a,(k1,k2) -> k1));

        //对对象进行按照key值进行分组
        Map<String, List<Student>> rlt3 = testStudentList.stream().collect(Collectors.groupingBy(Student::getSchoolName));

        //计算所有对象的年龄之和,最小值和最大值
        int totolAge  = testStudentList.stream().map(Student::getAge).reduce(0, Integer::sum);
        int minAge  = testStudentList.stream().map(Student::getAge).reduce(Integer.MAX_VALUE, Integer::min);
        int maxAge  = testStudentList.stream().map(Student::getAge).reduce(Integer.MIN_VALUE, Integer::max);

        System.out.println("OK");
    }
}
