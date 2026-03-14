package org.example;



import org.example.Assembler.DataAssembler;
import org.example.Collector.CpuCollector;
import org.example.Collector.DiskCollector;
import org.example.Collector.LoadCollector;
import org.example.Collector.MemoryCollector;
import org.example.Collector.NetworkDataCollector.NetworkCollector;
import org.example.Config.AgentConfig;
import org.example.Config.PropertyLoader;
import org.example.Scheduler.AgentScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger("Main.class");

    public static void main(String[] args)  {

        logger.info("Watchcow Agent Started");

        DataAssembler assembler = new DataAssembler(
                new CpuCollector(),
                new DiskCollector(),
                new MemoryCollector(),
                new LoadCollector(),
                new NetworkCollector()
        );

        AgentConfig agentConfig = new AgentConfig(new PropertyLoader());

        logger.info("Agent ID : {} " , agentConfig.getAgentId());
        logger.info("Agent Version : {} " , agentConfig.getVersion());
        logger.info("Scheduler Interval : {} " , agentConfig.getIntervalSeconds());
        logger.info("Injestor URL : {} " , agentConfig.getServerUrl());


        AgentScheduler agentScheduler = new AgentScheduler(assembler,agentConfig);

        agentScheduler.start();

    }
}