package com.example.springbatchprocessing;

import org.springframework.batch.item.ItemWriter;

import java.util.ArrayList;
import java.util.List;

public class SimpleChunkItemWriter implements ItemWriter<Integer> {
//    List<Integer> processed = new ArrayList<>();
    @Override
    public void write(List<? extends Integer> items) throws Exception {
        items.stream().forEach(System.out::println);
//        items.stream().map(Integer.class::cast).forEach(this.processed::add);
    }

}
