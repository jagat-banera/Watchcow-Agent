package org.example.Collector;

public class MemoryMetricsPacking {

    private final String totalMemory;
    private final String freeMemory ;
    private final String usedMemory ;

    public MemoryMetricsPacking(String totalMemory, String freeMemory, String usedMemory) {
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.usedMemory = usedMemory;
    }
}
