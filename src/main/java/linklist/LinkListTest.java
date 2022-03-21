package linklist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkListTest {


    public static void main(String[] args) {

        LinkedList<Integer> l1 = new LinkedList();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.add(7);
        System.out.println(l1);
//        for(int j=0;j<l1.size()-1;j++){
//            int pre=l1.get(j);
//            int next=l1.get(j+1);
//            if(pre<4 && 4<next){
//                l1.add(j+1,4);
//                break;
//            }
//        }
//        System.out.println(l1);

        System.out.println(l1.peek());
        LinkedList rl = revsers(l1);
        System.out.println(rl);

        LinkedList l2 = new LinkedList();
        l2.add(2);
        l2.add(4);
        l2.add(6);
        System.out.println(l2);


        LinkedList r2 = combineSorte(l1, l2);
        System.out.println(r2);
    }

    private static LinkedList combineSorte(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList rl = new LinkedList();
       while ( l1.size()>0){
        //for (int i = 0; i < l1.size(); i++) {
            int temp = l1.poll();//l1.get(i);
            if (temp < l2.getFirst()) {
                l2.addFirst(temp);
            }
            if (temp > l2.getLast()) {
                l2.addLast(temp);
            }
            for (int j = 0; j < l2.size() - 1; j++) {
                int pre = l2.get(j);
                int next = l2.get(j + 1);
                if (pre < temp && temp < next) {
                    l2.add(j + 1, temp);
                    break;
                }
            }
        }
        rl.addAll(l2);
        return rl;
    }

    private static LinkedList revsers(LinkedList l1) {
        LinkedList rl = new LinkedList();
        for (int i = l1.size() - 1; i >= 0; i--) {
            rl.add(l1.get(i));
        }
        return rl;
    }

}
