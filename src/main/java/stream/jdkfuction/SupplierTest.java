package stream.jdkfuction;

import module.Person;

import java.util.function.*;

/**
 * Supplier 是一个无参，生成一个对象的函数。共4个相关接口
 * 共有4个相关函数式接口
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Person> supplier = () -> Person.builder().firstName("gx").build();
        System.out.println(supplier.get());

        IntSupplier intSupplier = () -> Integer.valueOf(1);
        System.out.println(intSupplier.getAsInt());

        LongSupplier longSupplier = () -> Long.valueOf(1);
        System.out.println(longSupplier.getAsLong());

        DoubleSupplier doubleSupplier = () -> Double.valueOf(1);
        System.out.println(doubleSupplier.getAsDouble());

        BooleanSupplier booleanSupplier = () -> Boolean.FALSE;
        System.out.println(booleanSupplier.getAsBoolean());
    }

}