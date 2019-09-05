package org.wy.dataStructure;

import java.util.LinkedList;
import java.util.Stack;

public class StackByQueue<T> {


    private LinkedList<T> queue1;
    private LinkedList<T> queue2;


    public StackByQueue(LinkedList<T> queue1, LinkedList<T> queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
    }

    public T push(T item){
        if (queue1.isEmpty()){
            queue2.add(item);
        }
        else if (queue2.isEmpty()){
            queue1.add(item);
        }
        return item;
    }

    public T pop(){

        if (queue1.isEmpty() && queue2.isEmpty()) {
            return null;
        }
        if (queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }else if (queue2.isEmpty()){
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return null;
    }



}
