package org.example.Scheduler;

import org.example.Assembler.DataAssembler;
import org.example.Config.AgentConfig;
import org.example.Config.PropertyLoader;
import org.example.Service.SendServerMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AgentScheduler {

    private final DataAssembler assembler ;
    private final AgentConfig config ;
    private static final Logger logger = LoggerFactory.getLogger("AgentScheduler.class");

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
                logger.debug("Metrics Collected");


                // Send the request
                SendServerMetrics sendMetrics = new SendServerMetrics(metrics , new AgentConfig(new PropertyLoader()));
                sendMetrics.SendHttpRequest();
                logger.debug("Request Sent Successfully");

            }
            catch (Exception e){
                logger.error("Error Occurred While Sending Metrics : {} " , e.toString());
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

        }));

    }


}
