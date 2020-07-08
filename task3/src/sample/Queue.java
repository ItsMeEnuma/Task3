package sample;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private class QuereElement<T>{
        private T value;
        private QuereElement prev;

        public QuereElement(T value, QuereElement prev) {
            this.value = value;
            this.prev = prev;
        }

        public QuereElement(T value) {
            this.value = value;
            this.prev = null;
        }

        public T getValue() {
            return value;
        }

        public QuereElement getPrev() {
            return prev;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setPrev(QuereElement prev) {
            this.prev = prev;
        }
    }
    //последний элемент очереди
    private QuereElement<T> head;
    //первый елемент очереди
    private QuereElement<T> tail;
    private int length = 0;

    public int size(){
        return length;
    }

    public void push(T value){
        QuereElement<T> element = new QuereElement<T>(value);

        if(length == 0){
            head = tail = element;
            length++;
            return;
        }
        head.prev = element;
        head = element;
        length++;
    }
    public T pop(){
        if(length == 0)
            throw new Error();

        QuereElement<T> element = tail;
        tail = tail.getPrev();
        length--;
        return element.getValue();
    }

    public T top(){
        if(length == 0)
            throw new Error();

        return tail.getValue();
    }

    public List toList(){
        ArrayList<T> list = new ArrayList<>();

        QuereElement<T> e = tail;

        for(int i = 0; i < length; i++){
            list.add(e.getValue());
            e = e.getPrev();
        }

        return list;
    }

    public void clear(){
        head = tail = null;
        length = 0;
    }


}
