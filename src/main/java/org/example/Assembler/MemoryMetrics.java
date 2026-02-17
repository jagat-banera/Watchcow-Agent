package org.example.Assembler;


public class MemoryMetrics {

    private final double totalMemory;
    private final  double freeMemory ;
    private final  double usedMemory ;


    public MemoryMetrics(double totalMemory, double freeMemory, double usedMemory) {
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.usedMemory = usedMemory;
    }

    public double getTotalMemory() {
        return totalMemory;
    }

    public double getFreeMemory() {
        return freeMemory;
    }

    public double getUsedMemory() {
        return usedMemory;
    }
}
