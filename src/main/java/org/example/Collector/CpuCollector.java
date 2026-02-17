package org.example.Collector;

import com.sun.management.OperatingSystemMXBean;
import org.example.Assembler.CpuMetrics;

import java.lang.management.ManagementFactory;

public class CpuCollector implements Collector<CpuMetrics> {

    @Override
    public CpuMetrics collect() {
        OperatingSystemMXBean bean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double cpuLoad = bean.getCpuLoad();

        return new CpuMetrics(cpuLoad);
    }
}
