package org.example.Collector;

import com.sun.management.OperatingSystemMXBean;
import org.example.Assembler.CpuMetrics;
import org.example.Assembler.LoadAverageMetrics;

import java.lang.management.ManagementFactory;

public class LoadCollector implements Collector<LoadAverageMetrics>{


    @Override
    public LoadAverageMetrics collect() {
        OperatingSystemMXBean bean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double loadAverage = bean.getSystemLoadAverage();

        return new LoadAverageMetrics(loadAverage);
    }
}
