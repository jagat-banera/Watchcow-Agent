package org.example.Assembler;

import org.example.Assembler.NetworkDataAssembler.NetworkMetrcis;
import org.example.Collector.*;
import org.example.Config.AgentConfig;
import org.example.Config.AgentInfo;
import org.example.Config.PropertyLoader;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DataAssembler {

    /* Data Assembler Calls all the Collector classes */


    private final Collector<CpuMetrics> cpuCollector ;
    private final Collector<DiskMetrics> diskCollector ;
    private final Collector<MemoryMetrics> memoryCollector ;
    private final Collector<LoadAverageMetrics> loadCollector ;
    private final Collector<NetworkMetrcis> networkMetrcisCollector ;

    public DataAssembler(Collector<CpuMetrics> cpuCollector, Collector<DiskMetrics> diskCollector, Collector<MemoryMetrics> memoryCollector, Collector<LoadAverageMetrics> loadCollector, Collector<NetworkMetrcis> networkMetrcisCollector) {
        this.cpuCollector = cpuCollector;
        this.diskCollector = diskCollector;
        this.memoryCollector = memoryCollector;
        this.loadCollector = loadCollector;
        this.networkMetrcisCollector = networkMetrcisCollector;
    }


    public ServerMetrics collectAll() throws UnknownHostException {

        // Get the Agent Information ;
        AgentConfig agentConfig = new AgentConfig(new PropertyLoader());
        AgentInfo agentInfo = new AgentInfo(agentConfig.getAgentId() , InetAddress.getLocalHost().getHostName() , agentConfig.getVersion() );

        CpuMetrics cpu = cpuCollector.collect();
        DiskMetrics disk = diskCollector.collect();
        MemoryMetrics memory = memoryCollector.collect();
        LoadAverageMetrics load = loadCollector.collect();
        NetworkMetrcis network = networkMetrcisCollector.collect();

        return new ServerMetrics(agentInfo , cpu,disk,memory,load, network, System.currentTimeMillis());
    }

    public Collector<CpuMetrics> getCpuCollector() {
        return  cpuCollector;
    }

    public Collector<DiskMetrics> getDiskCollector() {
        return  diskCollector;
    }

    public Collector<MemoryMetrics> getMemoryCollector() {
        return  memoryCollector;
    }

    public Collector<LoadAverageMetrics> getLoadCollector() {
        return  loadCollector;
    }

    public Collector<NetworkMetrcis> getNetworkMetrcisCollector() {
        return networkMetrcisCollector;
    }
}
