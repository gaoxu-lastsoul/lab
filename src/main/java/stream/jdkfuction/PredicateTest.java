package stream.jdkfuction;

import module.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Predicate是个断言式接口其参数是<T,boolean>，也就是给一个参数T，返回boolean类型的结果。共5个相关接口
 * 详见：https://www.cnblogs.com/lastsoul/p/10270895.html
 */
public class PredicateTest {

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Predicate<Integer> p1 = i -> i > 5;
        Predicate<Integer> p2 = i -> i < 20;
        Predicate<Integer> p3 = i -> i % 2 == 0;
        List test =  Arrays.stream(numbers).filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());
        /** print:[6, 8, 10, 12, 14]*/

        List test2= Arrays.stream(numbers).filter(p1.and(p2).and(p3.negate())).collect(Collectors.toList());
        System.out.println(test2.toString());
        /** print:[7, 9, 11, 13, 15]*/

        List test3= Arrays.stream(numbers)
                .filter(p1.and(p2).and(p3.negate()).and(Predicate.isEqual(7)))
                .collect(Collectors.toList());
        System.out.println(test3.toString());
        /** print:[7] */

        BiPredicate<Person,Integer> biPredicate=(p,i)->i.equals(p.getAge());
        Boolean b1=biPredicate.test(Person.builder().age(300).build(),300);
        System.out.println(b1);
        /** true*/

        IntPredicate intPredicate=(i)->i>10;
        Boolean b2=intPredicate.test(11);
        System.out.println(b2);
    }

}