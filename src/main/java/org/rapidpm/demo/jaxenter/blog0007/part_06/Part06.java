package org.rapidpm.demo.jaxenter.blog0007.part_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.demo.jaxenter.blog0007.part_01.Worker;

/**
 * Created by Sven Ruppert on 18.11.13.
 */
public class Part06 {
    public static void main(String[] args) {
        final List<Integer> demoValues
                = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //limit the input
        System.out.println(demoValues
                .stream().limit(4)
                .collect(Collectors.toList()));

        //limit the result
        System.out.println(demoValues
                .stream().filter((v) -> v > 4)
                .limit(4)
                .collect(Collectors.toList()));

        System.out.println(demoValues
                .stream().substream(4)
                .collect(Collectors.toList()));

        System.out.println(demoValues
                .stream().sorted((v1, v2) -> Integer.compare(v2, v1))
                .collect(Collectors.toList()));

         // ex:
        // [77, 79, 81, 95, 43, 10, 53, 48, 74, 68, 60, 86, 83, 24, 57, 28, 8,
        //  85, 70, 66, 20, 14, 97, 73, 22, 36, 40, 39, 32, 19, 41, 67, 25, 88]
        final Random random = new Random();
        System.out.println(
                Stream.generate(() -> random.nextInt(100))
                .limit(40)
                .distinct()
                .collect(Collectors.toList())
        );

        //find the maximum
        System.out.println(demoValues
                .stream().max(Integer::compareTo)
        );
        //find the BUG ;-)
        System.out.println(demoValues
                .stream().min((v1, v2) -> Integer.compare(v2, v1))
        );

        // true, some are matching
        System.out.println("anyMatch " + demoValues.stream().map((e) -> {
                    System.out.println("e = " + e);
                    return e;
                })
                .anyMatch((v) -> v % 2 == 0));

        //false, not all are matching
        System.out.println("allMatch " + demoValues.stream().map((e) -> {
            System.out.println("e = " + e);
            return e;
        })
                .allMatch((v) -> v % 2 == 0));
        //false, not all are NOT matching
        System.out.println("noneMatch " + demoValues.stream() .map((e) -> {
            System.out.println("e = " + e);
            return e;
        })
                .noneMatch((v) -> v % 2 == 0));

        //5 matching the filter, 2,4,6,8,10
        System.out.println("count " + demoValues.stream().map((e) -> {
            System.out.println("e = " + e);
            return e;
        })
                .filter((v) -> v % 2 == 0)
        .count());


        System.out.println(demoValues.stream()  //seriell
                .map((m1) -> m1)
                .parallel()             .map((m2) -> m2)
                .sequential() //seriell
                .collect(Collectors.toList()));


    }
}
