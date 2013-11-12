package org.rapidpm.demo.jaxenter.blog0007.part_01;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.demo.jaxenter.blog0007.tools.WorkLoadGenerator;

/**
 * Created by Sven Ruppert on 11.11.13.
 */
public class WorkerParallelStreams implements Worker{

    @Override
    public List<List<Integer>> generateDemoValueMatrix(){
        return Stream
                .generate(this::generateDemoValuesForY)
                .limit(ANZAHL_KURVEN)
                .collect(Collectors.toList());
    }

    @Override
    public List<List<Double>> generateInterpolatedValues(List<List<Integer>> baseValues) {
        final List<List<Double>> baseValueMatrix = generateDemoValueMatrix()
                .parallelStream()
                .map(v -> {
                    final WorkLoadGenerator generator = new WorkLoadGenerator();
                    return generator.generate(v);
                })
                .collect(Collectors.toList());
        return baseValueMatrix;
    }

    public List<Integer> generateDemoValuesForY(){
        final Random random = new Random();
        return Stream
                .generate(() -> random.nextInt(MAX_GENERATED_INT))
                .limit(ANZAHL_MESSWERTE)
                .collect(Collectors.toList());
    }
}
