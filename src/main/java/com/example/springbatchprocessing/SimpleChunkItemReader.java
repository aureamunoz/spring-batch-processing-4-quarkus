package com.example.springbatchprocessing;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.StringTokenizer;

public class SimpleChunkItemReader implements ItemReader<Integer> {

    private static final Integer LIMIT = 25;
    private Integer count=0;

    @Override
    public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count < 25) {
            this.count++;
            return Integer.valueOf(count);
        }
        return null;
    }
}
