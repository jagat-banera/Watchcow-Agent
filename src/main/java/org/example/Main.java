package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Assembler.DataAssembler;
import org.example.Assembler.ServerMetrics;
import org.example.Collector.CpuCollector;
import org.example.Collector.DiskCollector;
import org.example.Collector.LoadCollector;
import org.example.Collector.MemoryCollector;
import org.example.Config.AgentConfig;
import org.example.Config.PropertyLoader;
import org.example.Scheduler.AgentScheduler;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args)  {

        DataAssembler assembler = new DataAssembler(
                new CpuCollector(),
                new DiskCollector(),
                new MemoryCollector(),
                new LoadCollector()
        );

        AgentConfig agentConfig = new AgentConfig(new PropertyLoader());

        AgentScheduler agentScheduler = new AgentScheduler(assembler,agentConfig);

        agentScheduler.start();












    }
}