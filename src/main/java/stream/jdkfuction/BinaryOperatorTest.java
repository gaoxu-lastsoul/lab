package stream.jdkfuction;

import module.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * BinaryOperator 是两个参数，生成一个对象的函数，是BiFunction的特化。共有4个相关函数式接口
 * BinaryOperator、IntBinaryOperator、LongBinaryOperator、DoubleBinaryOperator
 * <p>
 * UnaryOperator 是一个参数，生成一个对象的函数。共有4个相关函数式接口
 * UnaryOperator、IntUnaryOperator、LongUnaryOperator、DoubleUnaryOperator
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        String str="1,3,2";
        String s=Arrays.stream(str.split(",")).sorted(Comparator.comparing((Object n) -> n.toString())).collect(Collectors.joining(","));

        System.out.println(s);
        BinaryOperator<Integer> add = (n1, n2) -> n1 + n2;
        //apply方法用于接收参数，并返回BinaryOperator中的Integer类型
        System.out.println(add.apply(3, 4));

        BinaryOperator<String> addStr = (n1, n2) -> n1 + "===" + n2;
        //apply方法用于接收参数，并返回BinaryOperator中的String类型
        System.out.println(addStr.apply("3", "4"));

        BinaryOperator<Integer> bi = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println(bi.apply(2, 3));
        BinaryOperator<Integer> bi2 = BinaryOperator.minBy(Comparator.comparingInt((Integer n )-> n).reversed());
        System.out.println(bi2.apply(3, 2));
        BinaryOperator<Integer> bi5 = BinaryOperator.minBy(Comparator.comparingInt(n -> n));
        System.out.println(bi5.apply(3, 2));

        System.out.println("-----------------------");
        BinaryOperator<Integer> bi3 = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println(bi3.apply(2, 3));


        IntBinaryOperator intBinaryOperator = (n1, n2) -> n1 + n2;
        System.out.println(intBinaryOperator.applyAsInt(3, 4));

        System.out.println("-----------------------");
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(10));// 11
        UnaryOperator<String> ddb = x -> x + 1;
        System.out.println(ddb.apply("aa"));// aa1

        Person[] arrays = {Person.builder().age(1).build(), Person.builder().age(3).build(), Person.builder().age(2).build()};
        List<Person> list = Arrays.asList(arrays);
        System.out.println(list.stream().collect(Collectors.toMap(Person::getAge, Function.identity())));
        System.out.println(list.stream().collect(Collectors.toMap(Person::getAge, UnaryOperator.identity())));

    }
}
