package org.example.Assembler;

public class LoadAverageMetrics {

    private final double loadAverage  ;

    public LoadAverageMetrics(double loadAverage) {
        this.loadAverage = loadAverage;
    }

    public double getLoadAverage() {
        return loadAverage;
    }
}
