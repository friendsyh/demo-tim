import com.tim.common.domain.Student;
import com.tim.common.pojo.InitTestData;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 集合Stream各种测试
 * Created by tim.syh on 2017/1/8.
 */
public class StreamCollectTest extends InitTestData {

    private static final Logger logger = LoggerFactory.getLogger(StreamCollectTest.class);

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void toList() {
        // 按照年龄从小到大排序
        List<Student> newList = testStudentList = testStudentList
                .stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());

        // 打印数据
        newList.forEach(t -> logger.info(t.toString()));
    }

    @Test
    public void joining() {
        // 将学生姓名合并成以,分隔的字符串
        String names = testStudentList
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));

        // 打印数据
        System.out.println(names);
    }

    @Test
    public void mapping() {
        // 将学生姓名合并成以,分隔的字符串
        String names = testStudentList
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.joining(",")));

        // 打印数据
        System.out.println(names);
    }

    @Test
    public void collectingAndThen() {
        // 将学生姓名合并成以,分隔的字符串, 再通过 Function 对象将字符串转成 String[] 对象
        String[] nameArr = testStudentList
                .stream()
                .map(Student::getName)
                .collect(Collectors.collectingAndThen(Collectors.joining(","), data -> data.split(",")));

        // 打印数据
        for (int i = 0; i < nameArr.length; i++) {
            System.out.println(nameArr[i]);
        }
    }

    @Test
    public void counting() {
        // 将学生姓名合并成以,分隔的字符串, 再通过 Function 对象将字符串转成 String[] 对象
        Long count = testStudentList
                .stream()
                .filter(student -> student.getAge() > 20)
                .collect(Collectors.counting());

        // 打印数据
        System.out.println(String.format("年龄大于 20 的学生人数为:%s", count));
    }

    @Test
    public void minBy() {
        // 先去重，然后获取年龄最小的学生
        Optional<Student> student = testStudentList
                .stream()
                .distinct()
                .collect(Collectors.minBy((stu1, stu2) -> stu1.getAge() - stu2.getAge()));

        // 打印数据
        System.out.println(String.format("年龄最小的学生:%s", student.get().toString()));
    }

    @Test
    public void maxBy() {
        // 先去重，然后获取年龄最大的学生
        // 使用 Comparator.comparing
        Optional<Student> student = testStudentList
                .stream()
                .distinct()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));

        // 打印数据
        System.out.println(String.format("年龄最大的学生:%s", student.get().toString()));
    }

    @Test
    public void summingAge() {
        int total = testStudentList
                .stream()
                .distinct()
                .collect(Collectors.summingInt(Student::getAge));

        // 打印数据
        System.out.println(String.format("年龄总计:%s", total));
    }

    @Test
    public void averagingAge() {
        double average = testStudentList
                .stream()
                .distinct()
                .collect(Collectors.averagingInt(Student::getAge));

        // 打印数据
        System.out.println(String.format("平均年龄:%s", average));
    }

    @Test
    public void reducing() {
//        // 1 返回年龄最大的学生
//        // reducing 第一个参数 T identity 表示最终的返回类型或者结果的容器
//        Student studentMax = testStudentList
//                .stream()
//                .collect(Collectors.reducing(new Student(), (stu1, stu2) -> stu1.getAge() > stu2.getAge() ? stu1 : stu2));
//
//        // 打印数据
//        System.out.println(String.format("返回年龄最大的学生:%s", studentMax));
//
//        // 2 返回年龄最大的学生，不需要指定 返回类型或者结果的容器
//        Optional<Student> studentMin = testStudentList
//                .stream()
//                .collect(Collectors.reducing((stu1, stu2) -> stu1.getAge() > stu2.getAge() ? stu1 : stu2));
//
//        // 打印数据
//        System.out.println(String.format("返回年龄最大的学生:%s", studentMin.get().toString()));

        // 3 所有学生的年龄之和
        BigDecimal total = BigDecimal.ZERO;

        BigDecimal totalCredit = testStudentList
                .stream()
                .collect(Collectors.reducing(total, stu -> total.add(BigDecimal.valueOf(stu.getAge())), (data1, data2) -> data1.add(data2)));

        // 打印数据
        System.out.println(String.format("所有学生的年龄之和:%s", totalCredit));
    }

    @Test
    public void groupingBy() {
        // 按照学校分组
        Map<String, List<Student>> dataMap = testStudentList
                .stream()
                .collect(Collectors.groupingBy(Student::getSchoolName));

        // 打印数据
        dataMap.forEach((k,v) -> {
            System.out.println(String.format("学校：%s", k));
            v.forEach(System.out::println);
            System.out.println("---------------------------");
        });
    }

    @Test
    public void groupingByConcurrent() {
        // 按照学校分组
        Map<String, List<Student>> dataMap = testStudentList
                .stream()
                .collect(Collectors.groupingByConcurrent(Student::getSchoolName));

        // 打印数据
        dataMap.forEach((k,v) -> {
            System.out.println(String.format("学校：%s", k));
            v.forEach(System.out::println);
            System.out.println("---------------------------");
        });
    }

    @Test
    public void partitioningBy() {
        // 按照年龄是否大于 20 分组
        Map<Boolean, List<Student>> dataMap = testStudentList
                .stream()
                .collect(Collectors.partitioningBy(stu -> stu.getAge() > 20));

        // 打印数据
        dataMap.forEach((k,v) -> {
            System.out.println(k ? "年龄大于20：" : "年龄小于20：");
            v.forEach(System.out::println);
            System.out.println("---------------------------");
        });
    }

    @Test
    public void toMap() {
        // 将数据转成 Map
        Map<String, Integer> dataMap = testStudentList
                .stream()
                .collect(Collectors.toMap(stu -> stu.toString(), stu -> stu.getAge()));

        // 打印数据
        dataMap.forEach((k,v) -> {
            System.out.println(String.format("姓名：%s， 年龄：%s:", k, v));
        });
    }
}
