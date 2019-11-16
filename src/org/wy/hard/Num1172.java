package org.wy.hard;


import java.util.*;

public class Num1172 {


    private class Node {
        private boolean used;
        private int val;

        public Node(boolean used, int val) {
            this.used = used;
            this.val = val;
        }
    }


    private int capacity;
    private Stack<Integer> pushListIndex;
    private Stack<Integer> pushArrIndex;
    private List<Node[]> list;

    public Num1172(int capacity) {
        list = new LinkedList<>();
        Node[] nodes = new Node[capacity];
        list.add(nodes);

        this.capacity = capacity;
        pushArrIndex = new Stack<>();
        pushListIndex = new Stack<>();
        pushListIndex.push(0);
        pushArrIndex.push(0);
    }

    public void push(int val) {
        int listIndex = pushListIndex.pop();
        if (listIndex == list.size()) {
            Node[] nexts = new Node[capacity];
            list.add(nexts);
        }
        int arrIndex = pushArrIndex.pop();
        Node[] nodes = list.get(listIndex);
        nodes[arrIndex] = new Node(true, val);
        arrIndex++;
        if (arrIndex == capacity) {
            arrIndex = 0;
            listIndex++;
        }
        if (pushArrIndex.isEmpty()) {
            pushArrIndex.push(arrIndex);
            pushListIndex.push(listIndex);
        }
    }

    public int pop() {

        for (int i = list.size() - 1; i >= 0; i--) {
            Node[] nodes = list.get(i);
            for (int j = capacity - 1; j >= 0; j--) {
                if (nodes[j] != null) {
                    int res = nodes[j].val;
                    nodes[j] = null;
                    pushArrIndex.set(0, j);
                    if (j==capacity-1){
                        pushListIndex.set(0, i );
                    }
                    if (j==0){
                        list.remove(i);
                        pushListIndex.set(0, i );
                    }
                    return res;
                }
            }
//            list.remove(i);
//            pushListIndex.set(pushListIndex.size() - 1, i - 1);
        }
        return -1;

    }

    public int popAtStack(int index) {
        if (index >= list.size()) return -1;
        if (index == list.size() - 1) return pop();
        Node[] nodes = list.get(index);
        for (int i = capacity - 1; i >= 0; i--) {
            if (nodes[i] != null) {
                int res = nodes[i].val;
                nodes[i] = null;
//                int k = insertStack(pushListIndex,index);
                int k = erFen(pushListIndex,index,0,pushListIndex.size()-1);
                pushListIndex.add(k,index);
                pushArrIndex.add(k,i);
//                insertStack(pushArrIndex,i);
//                pushListIndex.push(index);
//                pushArrIndex.push(i);
                return res;
            }
        }
        return -1;
    }

    private int erFen(Stack<Integer> stack, int val, int low, int high){
//        if (stack.size()==1)return 1;
        if (low==high)return low+1;
        int mid = low+(high-low)/2;
        if (stack.get(mid)>=val){
           return erFen(stack,val,mid+1,high);
        }else {
           return erFen(stack,val,low,mid);
        }
    }



    public static void main(String[] args) {
        Num1172 num1172 = new Num1172(2);
//        num1172.push(1);
//        num1172.push(2);
//        num1172.push(3);
//        num1172.push(4);
//        num1172.push(5);
//        num1172.popAtStack(0);
//        num1172.push(20);
//        num1172.push(21);
//        num1172.popAtStack(0);
//        num1172.popAtStack(2);
//        num1172.pop();
//        num1172.pop();
//        num1172.pop();
//        num1172.pop();
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack);
//        System.out.println(stack.size());
//        stack.set(0,11);
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        stack.remove(0);
//        System.out.println(stack);
//        System.out.println(stack.size());

        Scanner scanner = new Scanner(System.in);
        List<Integer> pushList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            pushList.add(scanner.nextInt());
        }
        List<Integer> popAtStackList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            popAtStackList.add(scanner.nextInt());
        }
        for (Integer item : pushList) {
            num1172.push(item);
        }
        for (Integer item : popAtStackList) {
            System.out.println(num1172.popAtStack(item));
        }
        pushList.clear();
        for (int i = 0; i < 2; i++) {
            pushList.add(scanner.nextInt());
        }
        List<Integer> popList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            popList.add(scanner.nextInt());
        }

        for (Integer item : pushList) {
            num1172.push(item);
        }
        for (Integer popItem : popList) {
            System.out.println(num1172.pop());
        }
    }

}
