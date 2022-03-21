package stream.jdkfuction;

import module.Person;

import java.util.function.*;

/**
 *  Function 是一个参数，生成一个对象的函数，共有11个相关函数式接口
 *  Function、IntFunction、LongFunction、DoubleFunction、ToIntFunction、ToLongFunction、ToDoubleFunction
 *  、IntToLongFunction、IntToDoubleFunction、LongToIntFunction、LongToDoubleFunction
 *  BiFunction,两个入参，一个出参，共有4个相关函数式接口
 *  BiFunction、ToIntBiFunction、ToLongBiFunction、ToBiDoubleFunction
 */
public class FunctionTest {

    public static void main(String[] args) {
        int incr = 20;  int myNumber = 10;
        Function<Integer,Integer> function=val-> val + incr;
        Function<Integer,Integer> function2=val->  val* incr;

        modifyTheValue(myNumber, function);
        modifyTheValue(myNumber, function.andThen(function2));
        modifyTheValue(myNumber, function.compose(function2));

        //根据数字，生成T对象IntFunction、LongFunction、DoubleFunction
        //根据T对象，生成数字ToIntFunction、ToLongFunction、ToDoubleFunction
        IntFunction<Person> intFunction=(i)->Person.builder().age(i).build();
        System.out.println(intFunction.apply(20));

        LongFunction<Person> longFunction=(i)->Person.builder().age(((Long)i).intValue()).build();//根据数字，生成Person对象
        System.out.println(longFunction.apply(20));

        //BiFunction,两个入参，一个出参
        //根据T对象，生成数字ToIntBiFunction、ToLongBiFunction、ToBiDoubleFunction

    }
    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function){
        int newValue = function.apply(valueToBeOperated);
        System.out.println(newValue);
    }
}