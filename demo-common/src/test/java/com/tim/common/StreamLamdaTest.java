package com.tim.common;

import com.tim.common.domain.Person;
import com.tim.common.domain.Student;
import com.tim.common.pojo.InitTestData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 集合Stream各种测试
 * Created by tim.syh on 2017/1/8.
 */
public class StreamLamdaTest extends InitTestData {

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void testCollect() throws Exception {
        //把一个流收集成一个list,最常见的收集方法
        List<String> list11 = testStringList.stream().collect(Collectors.toList());
        //上面是一种简写,完整的写法应该如下。三个参数:1.目标容器 2.元素如何添加到容器中 3.多个部分结果如何合并
        List<String> list12 = testStringList.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        // 1.1 Supplier 对象负责创建容器对象，以便容纳 stream 中分隔后的数据，这里使用ArrayList作为数据的容器对象
        // 1.2 accumulator 对象负责将 stream 中分隔后的数据放入上一步创建的容器中
        // 1.3 combiner 对象负责将分隔的容器中的数据合并起来
        List<String> list13 = testStringList.stream().collect(() -> new ArrayList<>(), (list, data) -> list.add(data),
                (list1, list2) -> list1.addAll(list2));
        //这个在add的时候对字符串首字母变为大写。当然可以直接用map也是一样的
        List<String> list14 = testStringList.stream().collect(() -> new ArrayList<>(), (list, data) -> list.add(data.substring(0,1).toUpperCase().concat(data.substring(1))),
                (list1, list2) -> list1.addAll(list2));

        //collect返回是一个set,第一个返回hashset，第二个返回的是TreeSet
        Set<String> set1 = testStringList.stream().collect(Collectors.toSet());
        Set<String> set2 = testStringList.stream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

        //求每个字符串的长度。常用的构造器，一个是处理key，一个处理value。但是这种有重复的key就会报错,比如这个testStringList里面有两个suyanghua，会导致相同的key
//        Map<String, Integer> map1 = testStringList.stream().collect(Collectors.toMap(s -> s, s -> s.length()));
        //求每个字符串的长度。常用的构造器，一个是处理key，第二个处理value，第三个处理冲突的key只保留了第一个key
        Map<String, Integer> map2 = testStringList.stream().collect(Collectors.toMap(s -> s, s -> s.length(), (s1,s2) -> s1));
        //标准构造器，一个是处理key，第二个处理value，第三个处理冲突的key只保留了第一个key，第四个是结果容器,默认是hashMap，这里我使用了treeMap
        Map<String, Student> map3 = testStudentList.stream().collect(Collectors.toMap(stu -> stu.getSchoolName(), stu -> stu, (stu1, stu2) -> stu1,
                TreeMap::new));

        //对对象进行按照key值进行分组
        Map<String, List<Student>> rlt3 = testStudentList.stream().collect(Collectors.groupingBy(Student::getSchoolName));

        //获取每个字符串出现的次数
        Map<String, Long> map4 = testStringList.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        //counting就是求元素的个数
        Long collect = testStringList.stream().collect(Collectors.counting());

        System.out.println("OK");
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
    public void testSortedAndMap() throws Exception {
        String[] players = {"  Rafael Nadal  ", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer^","Roger Federer",
                "Andy Murray^","Tomas Berdych",
                "Juan Martin Del Potro"};

        //匿名函数写法。匿名函数主要是不可以复用
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        //匿名函数的写法就相当于这种。
        Arrays.sort(players, new MyComparator());
        //lamda表达式的写法
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

//        //用stream流这样写有问题，排好序了，但是返回的是一个流。不行
//        Arrays.stream(players).sorted();
//        //默认为升序排序,排序完成之后原来数组players没有变化。只是List排序了
//        List<String> rlt = Arrays.stream(players).sorted().collect(Collectors.toList());
//        System.out.println(Arrays.toString(players));

        //过滤以R开头的,对数据进行trim和替换
        List<String> rlt1 =
                Arrays.stream(players).map(item->item.trim().replace("^","")).filter(item->item.startsWith("R")).collect(Collectors.toList());
        rlt1.forEach((item)-> System.out.print(item + ","));
    }

    /**
     * forEach()是否可以修改元素的值
     * 1. 如果是基本数据类型是不能进行修改的
     * 2. 如果是引用类型可以修改单个元素的值，但是不能添加和删除元素，就和java的foreach循环一样的，用迭代器实现的
     * @throws Exception
     */
    @Test
    public void testForeachList() throws Exception {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

//        players.forEach((item) -> System.out.print(item + ";")); //普通打印方式
//        players.forEach(System.out::println); //普通打印方式
        players.stream().filter(item->item.startsWith("R")).forEach((item) -> System.out.print(item + ";")); //普通打印方式


    }

    @Test
    public void testForeachMap() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        map.put("F", 60);
        map.put("GG", 80);

        //进行遍历
        map.forEach((k,v)-> System.out.println("item:" + k + ",value:" + v));

        //把key转成一个List，并且进行排序
        List<String> rlt1 = map.keySet().stream().filter(item->item.length() < 2).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        String.join(",", rlt1);
    }


    /**
     * map 就是1对1 的转换
     * @throws Exception
     */
    @Test
    public void testStreamMap() throws Exception {
        //map就是转换。1对1的转换，所有转成大写
//        List<String> rlt2 = testStringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> rlt2 = testStringList.stream().map(item -> item.toUpperCase()).collect(Collectors.toList());

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

    /**
     * flatMap 就是1对多 的转换
     * @throws Exception
     */
    @Test
    public void testStreamFlatMap() throws Exception {
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "AB");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("AB", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

//        // Let's print all players before Java 8
//        List<String> listOfAllPlayers = new ArrayList<>();
//
//        for(List<String> team : playersInWorldCup2016){
//            for(String name : team){
//                listOfAllPlayers.add(name);
//            }
//        }
//
//        System.out.println("Players playing in world cup 2016");
//        System.out.println(listOfAllPlayers);


        // Now let's do this in Java 8 using FlatMap
//        List<String> flatMapList = playersInWorldCup2016.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());
        List<String> flatMapList = playersInWorldCup2016.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());

        System.out.println("List of all Players using Java 8");
        System.out.println(flatMapList);
    }

    /**
     * reduce 是一个归一化的迭代操作，多个变成一个。
     * 对于一个List<T> 的 toList返回的是Collection<T>,但是reduce操作之后返回的就是T本身
     * 很多函数的底层就是reduce来实现
     * @throws Exception
     */
    @Test
    public void testStreamReduce() throws Exception {
        //计算所有对象的年龄之和,最小值和最大值。
        //参数identity:默认值或者初始值  第二个参数:BinaryOperator,取两个值并且产生新的值
        int totolAge  = testStudentList.stream().map(Student::getAge).reduce(0, Integer::sum);
        int totolAge1  = testStudentList.stream().map(Student::getAge).reduce(0, (age1, age2) -> age1 + age2);
        //初始值如果设置为0,因为所有人年龄都大于0,得到的最小值就是0了,所以设置一个最大的整数值
        int minAge  = testStudentList.stream().map(Student::getAge).reduce(Integer.MAX_VALUE, Integer::min);
        int minAge1  = testStudentList.stream().map(Student::getAge).reduce(Integer.MAX_VALUE, (age1, age2) -> age1 < age2 ? age1 : age2);

        int maxAge  = testStudentList.stream().map(Student::getAge).reduce(Integer.MIN_VALUE, Integer::max);

        System.out.println("OK");
    }




    class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
