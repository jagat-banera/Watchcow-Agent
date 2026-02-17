package org.example.Collector;

public class DiskMetricsPacking {

    private final String totalDiskSpace;
    private final String freeDiskSpace;
    private final String usedDiskSpace;


    public DiskMetricsPacking(String totalDiskSpace, String freeDiskSpace, String usedDiskSpace) {
        this.totalDiskSpace = totalDiskSpace;
        this.freeDiskSpace = freeDiskSpace;
        this.usedDiskSpace = usedDiskSpace;
    }
}