package org.example.Assembler;

import org.example.Assembler.NetworkDataAssembler.NetworkMetrcis;
import org.example.Config.AgentInfo;

public class ServerMetrics  {

    private final AgentInfo agentInfo;
    private final CpuMetrics cpu ;
    private final DiskMetrics disk ;
    private final MemoryMetrics memory ;
    private final LoadAverageMetrics loadAverage ;
    private final NetworkMetrcis networkMetrcis ;
    private final long collectionTime ;

    public ServerMetrics(AgentInfo agentInfo , CpuMetrics cpu, DiskMetrics disk, MemoryMetrics memory, LoadAverageMetrics loadAverage, NetworkMetrcis networkMetrcis, long collectionTime) {
        this.agentInfo = agentInfo ;
        this.cpu = cpu;
        this.disk = disk;
        this.memory = memory;
        this.loadAverage = loadAverage;
        this.networkMetrcis = networkMetrcis;
        this.collectionTime = collectionTime;
    }

    public AgentInfo getAgentInfo() {
        return agentInfo;
    }

    public CpuMetrics getCpu() {
        return cpu;
    }

    public DiskMetrics getDisk() {
        return disk;
    }

    public MemoryMetrics getMemory() {
        return memory;
    }

    public LoadAverageMetrics getLoadAverage() {
        return loadAverage;
    }

    public NetworkMetrcis getNetworkMetrcis() {
        return networkMetrcis;
    }

    public long getCollectionTime() {
        return collectionTime;
    }
}
