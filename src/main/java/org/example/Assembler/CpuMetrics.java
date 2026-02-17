package org.example.Assembler;

public class CpuMetrics {

    private final double cpuLoad ;

    public CpuMetrics(double cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }
}
