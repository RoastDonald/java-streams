package com.company;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Продемонструйте можливі способи створення Stream<String>, а саме –
 * 1) на підставі набору значень;
 * 2) на підставі масиву
 * 3) на підставі колекції
 * 4) на підставі файлу
 * 5) згенерувати на підставі функції
 */

class Distance {
    int start;
    int end;

    public Distance(int  start,int end){
        this.start = start;
        this.end = end;
    }
}

public class StreamStrings {

    public void streamCollection(@NotNull List<String> list){
        Stream<String> strings = list.stream().map(e->{
            if(e == "2")return "0";
            else return e;
        });
        strings.forEach(System.out::println);
    }

    public void streamArray(@NotNull String[] array){
        Stream<String> stream = Stream.of(array).map(e->e.concat("stream"));
        stream.forEach(System.out::println);
    }

    public void streamFile(@NotNull String filename) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filename));
        long count = lines.map(e->e.isEmpty()).count();
        System.out.println(count);
    }

    public void streamFunction(){
        Stream<Distance> gens = Stream.generate(()->new Distance(0,100)).limit(5);
        gens.forEach(e->{
            System.out.printf("%s %s",e.end,e.start);
        });
    }

    public void streamSet(){
        Stream<String> stream = Stream.of("1","2","3").map(e->e.concat("stream"));
        stream.forEach(System.out::println);
    }

}
