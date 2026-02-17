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

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        DataAssembler assembler = new DataAssembler(
                new CpuCollector(),
                new DiskCollector(),
                new MemoryCollector(),
                new LoadCollector()
        );

        ServerMetrics metrics = assembler.collectAll();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(metrics);

        AgentConfig agentConfig = new AgentConfig(new PropertyLoader());

        System.out.println(json);

        System.out.println("Agent ID : " + agentConfig.getAgentId());

        System.out.println("Agent Version : " + agentConfig.getVersion());

        System.out.println("Interval : " + agentConfig.getIntervalSeconds());

        System.out.println("URL : " + agentConfig.getServerUrl());


    }
}