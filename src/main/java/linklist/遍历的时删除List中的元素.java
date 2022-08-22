package linklist;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * 遍历的时删除List中的元素
 * 1、使用foreach，报ConcurrentModificationException
 * 2、使用普通的for循环还是可以的，因为普通for循环并没有用到Iterator的遍历，所以压根就没有进行fail-fast的检验。
 * 3、使用Iterator，同普通for循环
 * 4、使用增强fail_safe的集合类，这样的集合容器在遍历时不是直接在集合内容上访问的，而是先复制原有集合内容，在拷贝的集合上进行遍历，所以不会触发ConcurrentModificationException。
 * 5、推荐使用Stream，Java 8中可以把集合转换成流，对于流有一种filter操作， 可以对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
 * 6、其实也是可以使用增强for循环的，只要在删除之后，立刻结束循环体，不要再继续进行遍历就可以了，也就是说不让代码执行到下一次的next方法。见增强for循环(List<String> userNames)方法的注释。
 * 以上几种方法都会改变List中元素的下标,并且当有重复元素时，只能删除一个，使用Stream时建议先去重
 */
public class 遍历的时删除List中的元素 {
    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        //普通for循环(userNames);
        //使用Iterator(userNames);
        //增强for循环(userNames);
        //增强fail_safe的集合类(userNames);
        //使用Stream
        使用Stream(userNames);
        System.out.println(userNames);


    }

    private static void 使用Stream(List<String> userNames) {
        List<String> userNames2 = userNames.stream().filter(userName -> !userName.equals("Hollis")).collect(Collectors.toList());
        System.out.println(userNames2);
        System.out.println(111);
    }

    private static void 增强fail_safe的集合类(List<String> userNames) {
        ConcurrentLinkedDeque<String> userNames2 = new ConcurrentLinkedDeque<String>(userNames);

        for (String userName : userNames2) {
            if (userName.equals("Hollis")) {
                userNames2.remove();
            }
        }
        System.out.println(userNames2);
    }

    private static void 增强for循环(List<String> userNames) {
        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
                //break;
            }
        }
    }

    private static void 使用Iterator(List<String> userNames) {
        Iterator iterator = userNames.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals("Hollis")) {
                iterator.remove();
            }
        }
    }


    private static void 普通for循环(List<String> userNames) {
        for (int i = 0; i < 1; i++) {
            if (userNames.get(i).equals("Hollis")) {
                userNames.remove(i);
            }
        }
    }

}