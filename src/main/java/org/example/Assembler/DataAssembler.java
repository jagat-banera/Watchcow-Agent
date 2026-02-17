package org.example.Assembler;

import org.example.Collector.*;

public class DataAssembler {

    /* Data Assembler Calls all the Collector classes */

    private final Collector<CpuMetrics> cpuCollector ;
    private final Collector<DiskMetrics> diskCollector ;
    private final Collector<MemoryMetrics> memoryCollector ;
    private final Collector<LoadAverageMetrics> loadCollector ;

    public DataAssembler(Collector<CpuMetrics> cpuCollector, Collector<DiskMetrics> diskCollector, Collector<MemoryMetrics> memoryCollector, Collector<LoadAverageMetrics> loadCollector) {
        this.cpuCollector = cpuCollector;
        this.diskCollector = diskCollector;
        this.memoryCollector = memoryCollector;
        this.loadCollector = loadCollector;
    }


    public ServerMetrics collectAll(){
        CpuMetrics cpu = cpuCollector.collect();
        DiskMetrics disk = diskCollector.collect();
        MemoryMetrics memory = memoryCollector.collect();
        LoadAverageMetrics load = loadCollector.collect();

        return new ServerMetrics(cpu,disk,memory,load, System.currentTimeMillis());
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
}
