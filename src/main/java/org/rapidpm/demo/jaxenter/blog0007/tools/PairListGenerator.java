package org.rapidpm.demo.jaxenter.blog0007.tools;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.demo.jaxenter.blog0007.model.Pair;

/**
 * Created by Sven Ruppert on 15.11.13.
 */

public interface PairListGenerator {

    public default List<Pair> generateDemoValues(){
        final Random random = new Random();
        return Stream
                .generate(() -> {
                    final Pair p = new Pair();
                    p.id = random.nextInt(100);
                    p.value = "Value + " + p.id;
                    return p;
                })
                .limit(100)
                .collect(Collectors.toList());
    }

}
