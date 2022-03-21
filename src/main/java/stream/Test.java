package stream;

import module.Parent;
import module.Person;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
       int[] nums=new int[]{1,2,3,1,3};
        singleNumber(nums);
    }
    public static int singleNumber(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        System.out.println(sum);
       // Set<Integer> set = new HashSet(Arrays.asList(nums));
        Arrays.asList(nums).forEach(System.out::println);
//        int sum2=set.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(sum2);
        return 1;
    }
}
