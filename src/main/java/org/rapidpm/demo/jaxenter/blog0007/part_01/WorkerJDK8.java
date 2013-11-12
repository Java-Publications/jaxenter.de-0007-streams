package org.rapidpm.demo.jaxenter.blog0007.part_01;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 11.11.13.
 */


//@FunctionalInterface
public interface WorkerJDK8 extends Worker{

//    public default List<List<Integer>> generateDemoValueMatrix(){
//        return Stream
//                .generate(() -> {
//                    final Random random = new Random();
//                    return Stream
//                            .generate(() -> random.nextInt(MAX_GENERATED_INT))
//                            .limit(ANZAHL_MESSWERTE)
//                            .collect((Collector<? super Integer, ? extends Object, ? extends List<Integer>>) Collectors.toList());
//                })
//                .limit(ANZAHL_KURVEN)
//                .collect(Collectors.toList());
//    }

    /**
     * seriell default Implementierung
     * @param baseValues
     * @return
     */
    public default List<List<Double>> generateInterpolatedValues(List<List<Integer>> baseValues){
        final List<List<Double>> baseValueMatrix = generateDemoValueMatrix()
                .stream()
                .map(v -> {
                    final WorkLoadGenerator generator = new WorkLoadGenerator();
                    return generator.generate(v);
                })
                .collect(Collectors.toList());
        return baseValueMatrix;
    }


    public default List<List<Integer>> generateDemoValueMatrix(){
        return Stream
                .generate(this::generateDemoValuesForY)
//                .generate(list)
                .limit(ANZAHL_KURVEN)
                .collect(Collectors.toList());
    }

    public default List<Integer> generateDemoValuesForY(){
        final Random random = new Random();
        return Stream
                .generate(() -> random.nextInt(MAX_GENERATED_INT))
                .limit(ANZAHL_MESSWERTE)
                .collect(Collectors.toList());
    }


}
