package org.example.Service;

import org.example.Assembler.NetworkDataAssembler.NetworkIntefaceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LinuxNetworkExtractor {

    private List<NetworkIntefaceData> intefaceDatalist = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(LinuxNetworkExtractor.class);


    public LinuxNetworkExtractor() {
        // Fallback to Zero -1;


    }

    public void NetworkPacketsExtractor()  {

        try{
            List<String> list = Files.readAllLines(Path.of("/proc/net/dev"));
            int lineNumber = 0 ;


            for(String line : list){
                lineNumber++ ;
                if(lineNumber <= 2){
                    continue;
                }

                String[] parts = line.split(":");

                String interfaceName = parts[0].trim();

                String[] transmitValues = parts[1].trim().split("\\s+");

                double received = Double.parseDouble(transmitValues[0]);
                double sent = Double.parseDouble(transmitValues[8]);


                // Add the values in the list ;
                intefaceDatalist.add(new NetworkIntefaceData(interfaceName,sent,received));
            }

        }
        catch (Exception e){
            logger.error("Not able to Read file Located in /proc/net/dev due to error : {} " , e.getMessage());
            logger.error("Falling Back to NULL Values....");
        }

    }

    public List<NetworkIntefaceData> getIntefaceDatalist() {
        return intefaceDatalist;
    }
}
