package org.example.Collector;

import com.sun.management.OperatingSystemMXBean;
import org.example.Assembler.CpuMetrics;
import org.example.Assembler.DiskMetrics;

import java.io.File;
import java.lang.management.ManagementFactory;

public class DiskCollector implements Collector<DiskMetrics>{

    @Override
    public DiskMetrics collect() {

        File disk = new File("/");

        double totalDiskSpace = disk.getTotalSpace();
        double freeDiskSpace = disk.getFreeSpace();
        double usedDiskSpace = totalDiskSpace - freeDiskSpace ;

        return new DiskMetrics(totalDiskSpace,freeDiskSpace,usedDiskSpace);
    }
}