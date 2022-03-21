package module;


import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Data
@Builder
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;

    public static void main(String[] args) {

        /*List<Person> list1 = new ArrayList<Person>();
        list1.add( Person.builder().id(1L).build());
        list1.add( Person.builder().id(2L).build());
        List<Person> list2 = new ArrayList<Person>();
        list2.add( Person.builder().id(3L).build());
        list2.add( Person.builder().id(2L).build());*/
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("7");
        Predicate<String> predicate=list2::contains;
        List<String> reduce1 = list1.stream().filter(predicate.negate()).collect(toList());

        System.out.println(reduce1);
    }
}
