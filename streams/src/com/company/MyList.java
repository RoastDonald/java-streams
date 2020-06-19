package com.company;

import java.util.Arrays;

/**
 Розробіть  свою узагальнену колекцію типу List.
 В якості структури в якій будете зберігати дані оберіть масив.
 */
public class MyList<E>{
    private int size = 0;
    private static final int DEFAULT = 15;
    private Object items[];

    public MyList(){
        items = new Object[DEFAULT];
    }

    private void addMoreCapacity(){
        int size = items.length *2;
        items = Arrays.copyOf(items,size);
    }

    public void remove(int i){
        if(i >= size || i<0)throw new IndexOutOfBoundsException(Integer.toString(i));
        for(;i <size;i++){
            items[i] = items[i+1];
        }
    }
    public void add(E item){
        if(size == items.length)addMoreCapacity();
        items[size++] = item;
    }

    public E get(int i){
        if(i >= size || i<0)throw new IndexOutOfBoundsException(Integer.toString(i));
        return (E) items[i];
    }
}
