package org.example.Assembler;

public class DiskMetrics {

    private final double totalDiskSpace;
    private final double freeDiskSpace;
    private final double usedDiskSpace;

    public DiskMetrics(double totalDiskSpace, double freeDiskSpace, double usedDiskSpace) {
        this.totalDiskSpace = totalDiskSpace;
        this.freeDiskSpace = freeDiskSpace;
        this.usedDiskSpace = usedDiskSpace;
    }

    public double getTotalDiskSpace() {
        return totalDiskSpace;
    }

    public double getFreeDiskSpace() {
        return freeDiskSpace;
    }

    public double getUsedDiskSpace() {
        return usedDiskSpace;
    }
}