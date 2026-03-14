package org.example.Service;

import com.sun.management.OperatingSystemMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinuxMemoryExtractor {

    private double totalMemory ;
    private double freeMemory ;

    private static final Logger logger = LoggerFactory.getLogger(LinuxMemoryExtractor.class);

    public LinuxMemoryExtractor() {

        // FallBack Method in Case of Reading Failes.

         OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();


         totalMemory = bean.getTotalMemorySize();
         freeMemory = bean.getFreeMemorySize();

          collectLinuxMemoryData();

    }

    public void collectLinuxMemoryData(){

        try{
            List<String> lines = Files.readAllLines(Path.of("/proc/meminfo"));
            Map<String,Double> values = new HashMap<>();

            for(String line : lines){

                String[] parts = line.split(":");
                String key = parts[0];

                String number = parts[1].trim().split(" ")[0];

                Double valueBytes = Double.parseDouble(number)*1024 ;

                values.put(key,valueBytes);
            }

            totalMemory = values.getOrDefault("MemTotal" , totalMemory);
            freeMemory = values.getOrDefault("MemAvailable", freeMemory);

        }
        catch (Exception e){
            logger.error("Not able to Read meminfo file due to error : {} " , e.getMessage());
            logger.error("Falling Back to Bean Values....");
        }

    }

    public double getTotalMemory() {
        return totalMemory;
    }

    public double getFreeMemory() {
        return freeMemory;
    }
}
