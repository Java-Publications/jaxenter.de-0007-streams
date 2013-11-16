package org.rapidpm.demo.jaxenter.blog0007.part_03;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.demo.jaxenter.blog0007.model.Pair;
import org.rapidpm.demo.jaxenter.blog0007.tools.PairListGenerator;

/**
 * Created by Sven Ruppert on 14.11.13.
 */
public class Part03 {

    public static void main(String[] args) {
        final List<Pair> generateDemoValues = new PairListGenerator(){}.generateDemoValues();

        //pre JDK8
        for (final Pair generateDemoValue : generateDemoValues) {
            System.out.println(generateDemoValue);
        }

        //long version
        generateDemoValues.stream().forEach(v -> System.out.println(v) );

        //short version
        generateDemoValues.stream().forEach(System.out::println);
        generateDemoValues.parallelStream().forEach(System.out::println);


        generateDemoValues.stream().forEachOrdered(System.out::println);
        generateDemoValues.parallelStream().forEachOrdered(System.out::println);


        final Consumer<? super Pair> consumer = System.out::println;
        generateDemoValues.stream().forEachOrdered(consumer);
        generateDemoValues.parallelStream().forEachOrdered(consumer);


        //map from Point to DemoElements
        final Stream<DemoElement> demoElementStream = generateDemoValues.stream().map(v -> {
            final String value = v.getValue();
            final DemoElement d = new DemoElement();
            d.setDatum(new Date());
            d.setValue(Base64.getEncoder().encodeToString(value.getBytes()));
            return d;
        });

        final Stream<String> stringStream = demoElementStream.map(v -> v.getValue());
        final Stream<String> stringStreamShort = demoElementStream.map(DemoElement::getValue);

        //map from Point to DemoElements to Strings
        final List<String> stringList = generateDemoValues.stream().map(v -> {
            final String value = v.getValue();
            final DemoElement d = new DemoElement();
            d.setDatum(new Date());
            d.setValue(Base64.getEncoder().encodeToString(value.getBytes()));
            return d;
        }).map(DemoElement::getValue).collect(Collectors.toList());

        final Stream<Pair> filteredPairStream = generateDemoValues.stream().filter(v -> v.getId() % 2 == 0);






    }



}
