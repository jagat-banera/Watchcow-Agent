package org.example.Collector;

import com.sun.management.OperatingSystemMXBean;
import org.example.Assembler.DiskMetrics;
import org.example.Assembler.MemoryMetrics;
import org.example.Service.LinuxMemoryExtractor;

import java.io.File;
import java.lang.management.ManagementFactory;

public class MemoryCollector implements Collector<MemoryMetrics>{

    @Override
    public MemoryMetrics collect() {


        // A Custom Memory Extractor is used here insted of OSMXBean Java API
        // Reason --> OSMXBean does not correctly read Linux Memory Stats

        LinuxMemoryExtractor extractor = new LinuxMemoryExtractor();

        double totalMemory = extractor.getTotalMemory();
        double freeMemory = extractor.getFreeMemory();
        double usedMemory = totalMemory - freeMemory ;

        return new MemoryMetrics(totalMemory,freeMemory,usedMemory);
    }
}
