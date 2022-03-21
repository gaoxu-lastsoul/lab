package com.java.duncan;  
class Node {  
    public int value;  
    public Node next;  
    public Node() {  
        value = -1;  
        next = null;  
    }  
    public Node(int i) {  
        value = i;  
        next = null;  
    }  
    public void add(Node head, Node add) {  
        Node p = head;  
        if(p == null) return;  
        while(p.next != null) {  
            p = p.next;  
        }  
        p.next = add;  
    }  
    public void print(Node head) {  
        Node p = head;  
        if(p == null) System.out.println("链表为空！");  
        while(p != null) {  
            System.out.print(p.value + " ");  
            p = p.next;  
        }  
    }  
    public void reversePrint(Node node) {  
        if(node.next != null) {  
            reversePrint(node.next);  
            System.out.print(node.value + " ");  
        }  
    }

    public Node Reverse2(Node head) {
        if(head==null || head.next==null) return head;
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = p2.next;
        p1.next = null;
        while(p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }
    public Node Reverse(Node head) {
        if(head==null || head.next==null) return head;  
        Node p1 = head;
        Node p2 = head.next;  
        Node p3 = p2.next;  
        p1.next = null;  
        while(p3 != null) {  
            p2.next = p1;  
            p1 = p2;  
            p2 = p3;  
            p3 = p3.next;  
        }  
        p2.next = p1;  
        return p2;  
    }

    public Node reverseList(Node head) {
//保存前一个节点
        Node prev = null;
//保存当前要更改next的指针的节点
        Node curr = head;
//当curr==null的时候表示已经到了末尾，就不需要再变了
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    }
  
public class ReverseList {  
    public static void main(String[] args) {  
        Node head = new Node();  
        for(int i = 1; i <= 10; i++) {  
            head.add(head,new Node(i));  
        }  
        head.print(head.reverseList(head));
        //System.out.println();  
        //head.reversePrint(head);  
          
    }  
}  