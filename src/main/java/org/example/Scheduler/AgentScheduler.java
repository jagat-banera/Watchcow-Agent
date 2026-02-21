package org.example.Scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Assembler.DataAssembler;
import org.example.Assembler.ServerMetrics;
import org.example.Config.AgentConfig;
import org.example.Config.PropertyLoader;
import org.example.Service.SendMetrics;

import java.net.URL;
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
                // Collect the Metrcis
                var metrics = assembler.collectAll();

                // Send the request
                SendMetrics sendMetrics = new SendMetrics(metrics , new AgentConfig(new PropertyLoader()));

                sendMetrics.SendHttpRequest();

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
