package org.example.Collector;

import com.sun.management.OperatingSystemMXBean;
import org.example.Assembler.DiskMetrics;
import org.example.Assembler.MemoryMetrics;

import java.io.File;
import java.lang.management.ManagementFactory;

public class MemoryCollector implements Collector<MemoryMetrics>{

    @Override
    public MemoryMetrics collect() {

        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double totalMemory = bean.getTotalMemorySize();
        double freeMemory = bean.getFreeMemorySize();
        double usedMemory = totalMemory - freeMemory ;

        return new MemoryMetrics(totalMemory,freeMemory,usedMemory);
    }
}
