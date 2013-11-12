package org.rapidpm.demo.jaxenter.blog0007.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.rapidpm.demo.jaxenter.blog0007.part_01.Worker;

/**
 * Created by Sven Ruppert on 12.11.13.
 */
public interface DemoValueGenerator {

    //implement with streams
    public default List<Integer> generateDemoValuesForY() {
        final Random random = new Random();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Worker.ANZAHL_MESSWERTE; i++) {
            final int nextInt = random.nextInt(Worker.MAX_GENERATED_INT);
            result.add(nextInt);
        }
        return result;
    }
}
