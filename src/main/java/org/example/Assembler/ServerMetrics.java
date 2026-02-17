package org.example.Assembler;

import java.util.Date;

public class ServerMetrics  {

    private final CpuMetrics cpu ;
    private final DiskMetrics disk ;
    private final MemoryMetrics memory ;
    private final LoadAverageMetrics loadAverage ;
    private final long collectionTime ;

    public ServerMetrics(CpuMetrics cpu, DiskMetrics disk, MemoryMetrics memory, LoadAverageMetrics loadAverage, long collectionTime) {
        this.cpu = cpu;
        this.disk = disk;
        this.memory = memory;
        this.loadAverage = loadAverage;
        this.collectionTime = collectionTime;
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

    public long getCollectionTime() {
        return collectionTime;
    }
}
