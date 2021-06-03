package com.example.springbatchprocessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public SimpleChunkItemProcessor processor() {
        return new SimpleChunkItemProcessor();
    }

    @Bean
    public SimpleChunkItemReader reader() {
        return new SimpleChunkItemReader();
    }

    @Bean
    public SimpleChunkItemWriter writer() {
        return new SimpleChunkItemWriter();
    }

    @Bean
    public Job importUserJob(Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(SimpleChunkItemWriter writer) {
        return stepBuilderFactory.get("step1")
            .<Integer, Integer> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }

}
