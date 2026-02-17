package org.example.Scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Assembler.DataAssembler;
import org.example.Config.AgentConfig;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AgentScheduler {

    private final DataAssembler assembler ;
    private final AgentConfig config ;

    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    public AgentScheduler(DataAssembler assembler, AgentConfig config) {
        this.assembler = assembler;
        this.config = config;
    }

    public void start(){
        Runnable task = () -> {
            try {
                var metrics = assembler.collectAll();
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(metrics);
                System.out.println(json);
            }
            catch (Exception e){
                System.out.println(e);
            }
        };

        scheduler.scheduleAtFixedRate(
                task,
                0,
                config.getIntervalSeconds(),
                TimeUnit.SECONDS
        );

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            scheduler.shutdown();
            System.out.println("Agent shutting down...");
        }));

    }


}
