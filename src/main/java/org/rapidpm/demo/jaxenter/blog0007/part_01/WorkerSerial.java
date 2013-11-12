package org.rapidpm.demo.jaxenter.blog0007.part_01;

import java.util.ArrayList;
import java.util.List;

import org.rapidpm.demo.jaxenter.blog0007.tools.DemoValueGenerator;
import org.rapidpm.demo.jaxenter.blog0007.tools.WorkLoadGenerator;

/**
 * Created by Sven Ruppert on 11.11.13.
 */
public class WorkerSerial implements Worker {

    @Override
    public List<List<Double>> generateInterpolatedValues(List<List<Integer>> baseValues) {
        final WorkLoadGenerator generator = new WorkLoadGenerator();
        final List<List<Double>> result = new ArrayList<>();
        for (final List<Integer> valueList : baseValues) {
            final List<Double> doubleList = generator.generate(valueList);
            result.add(doubleList);
        }
        return result;
    }


    private DemoValueGenerator valueGenerator = new DemoValueGenerator(){};

    public List<List<Integer>> generateDemoValueMatrix() {
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ANZAHL_KURVEN; i++) {
            final List<Integer> demoValuesForY = valueGenerator.generateDemoValuesForY();
            result.add(demoValuesForY);
        }
        return result;
    }
}
