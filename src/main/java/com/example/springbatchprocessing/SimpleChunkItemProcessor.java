package com.example.springbatchprocessing;


import org.springframework.batch.item.ItemProcessor;

public class SimpleChunkItemProcessor implements ItemProcessor<Integer, Integer> {

    @Override
    public Integer process(Integer t) {
        return ((Integer) t).intValue() % 2 == 0 ? null : ((Integer) t).intValue();
    }
}
