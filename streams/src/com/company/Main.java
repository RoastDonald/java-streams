package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static String [] testArray = {"1","2"};

    public static void main(String[] args) {
        Main.testStreams();
        Main.testParser();
        Main.testList();

    }

    private static void testList(){
        MyList<String[]> t = new MyList<>();
        t.add(testArray);
        t.add(testArray);
        t.add(testArray);
        System.out.println(Arrays.toString(t.get(1)));
        t.remove(1);
    }

    private static void testParser(){
        String link = "https://www.baeldung.com/find-list-element-java";
        Parser p = new Parser();
        long c  = p.countImages(link);
        System.out.println(c);
    }

    private static void testStreams(){
        List<String> list = new ArrayList<>();
        for(var i =0; i<10;i++){
            list.add(Integer.toString(i));
        }
        StreamStrings s = new StreamStrings();
        s.streamArray(testArray);
        s.streamCollection(list);
        s.streamFunction();
        s.streamSet();
    }
}
