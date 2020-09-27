package com.nayanzin.javaversions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Java9Features {
    public static void main(String[] args) {

        // Collections got a couple of new helper methods to easily construct Lists, Sets, and Maps.
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<String, String> map = Map.of("foo", "one", "bar", "two");

        // Streams got a couple of additions, in the form of takeWhile, dropWhile, and iterate methods.
        Stream<String> stream = Stream.iterate("", s -> s + "s")
                .takeWhile(s -> s.length() < 10);

        // Optionals got the sorely missed ifPresentOrElse method.
        Optional.of(10).ifPresentOrElse(System.out::println, () -> System.out.println("Not present"));

        // In Java9, we don't need to declare br1 anymore and following program will give the same result.
        Reader inputString = new StringReader("sf");
        BufferedReader br = new BufferedReader(inputString);
        try (br) {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Interfaces got private methods:
interface Java9InterfaceWithPrivateMethod {
    private static void myPrivateMethod(){
        System.out.println("Yay, I am private!");
    }
}
