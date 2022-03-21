//package stream.jdkfuction;
//
//import module.Person;
//
//import java.util.function.BiConsumer;
//import java.util.function.Consumer;
//import java.util.function.DoubleConsumer;
//import java.util.function.ObjIntConsumer;
//
///**
// * Consumer的作用是给定义一个参数,对其进行(消费)处理,处理的方式可以是任意操作.共8个相关接口
// * 详见：https://www.cnblogs.com/lastsoul/p/10268324.html
// */
//public class ConsumerTest {
//
//    public static void main(String[] args) {
//        Consumer<Person> consumer = (p) -> System.out.println(p.getFirstName());
//        consumer.accept(Person.builder().firstName("zs").build());
//        consumer.andThen((p) -> System.out.println(p.getLastName())).accept(Person.builder().firstName("san feng").lastName("zhang").build());
//
//        DoubleConsumer doubleConsumer = (d) -> System.out.println(d);
//        doubleConsumer.accept(23.2d);
//
//        BiConsumer<String, Person> biConsumer = (str, p) -> System.out.println(str + p.getFirstName());
//        biConsumer.accept("hello ", Person.builder().firstName("san feng").lastName("zhang").build());
//
//        ObjIntConsumer<Person> objIntConsumer = (Person ps, int i) -> {
//            ps.setAge(i);
//            System.out.println(ps.getFirstName()+":"+ps.getAge());
//        };
//        objIntConsumer.accept(Person.builder().firstName("san feng").lastName("zhang").build(), 300);
//
//        //常用使用方式
//        Consumer<Person> consumer1 = (p) -> System.out.println(p.getFirstName());
//        Consumer<Person> consumer2 = (p) -> System.out.println(p.getLastName());
//        Person p=Person.builder().firstName("san feng").lastName("zhang").build();
//        System.out.println("===========testConsumer start================");
//        testConsumer(p,consumer1.andThen(consumer2));
//        System.out.println("============testConsumer end===============");
//    }
//
//    public static void testConsumer(Person p, Consumer<Person> c) {
//        c.accept(p);
//    }
//
//}