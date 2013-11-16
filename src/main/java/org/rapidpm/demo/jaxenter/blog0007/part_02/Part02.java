package org.rapidpm.demo.jaxenter.blog0007.part_02;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.rapidpm.demo.jaxenter.blog0007.model.Pair;
import org.rapidpm.demo.jaxenter.blog0007.tools.PairListGenerator;

/**
 * Created by Sven Ruppert on 13.11.13.
 */
public class Part02 {



    public static void main(String[] args) {

        final List<Pair> generateDemoValues = new PairListGenerator(){}.generateDemoValues();

        //Stream from Values
        final Stream<Pair> fromValues = Stream.of(new Pair(), new Pair());

        //Stream from Array
        final Pair[] pairs = {new Pair(), new Pair()};
        final Stream<Pair> fromArray = Stream.of(pairs);

        //Stream from List
        final Stream<Pair> fromList = generateDemoValues.stream();

        //Stream from String
        final Stream<String> abc = Stream.of("ABC");
        final Stream<IntStream> of = Stream.of("ABC".chars());
        final Stream<String> splitOf = Stream.of("A,B,C".split(","));

        //Stream from builder
        final Stream<Pair> builderPairStream = Stream.<Pair>builder().add(new Pair()).build();


        //Stream to Array
        final Pair[] toArray = generateDemoValues.stream().toArray(Pair[]::new);
        //Stream to List
        final List<Pair> toList = generateDemoValues.stream().collect(Collectors.toList());

        //Stream to Set
        final Set<Pair> toSet = generateDemoValues.stream().collect(Collectors.toSet());

        //Stream to Map
        final Map<Integer,List<Pair>> collectedToMap = generateDemoValues.stream().collect(Collectors.groupingBy(Pair::getId));
        System.out.println("collectedToMap.size() = " + collectedToMap.size());

        for (final Map.Entry<Integer, List<Pair>> entry : collectedToMap.entrySet()) {
            System.out.println("entry = " + entry);
        }

    }



}
