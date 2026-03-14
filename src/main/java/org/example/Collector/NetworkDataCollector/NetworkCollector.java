package org.example.Collector.NetworkDataCollector;

import org.example.Assembler.NetworkDataAssembler.NetworkMetrcis;
import org.example.Collector.Collector;
import org.example.Service.LinuxNetworkExtractor;

import java.net.UnknownHostException;

public class NetworkCollector implements Collector<NetworkMetrcis> {

    @Override
    public NetworkMetrcis collect() throws UnknownHostException {
       // Call the LinuxNetworkExtratcr to collect send and received bytes to all interfaces
        LinuxNetworkExtractor networkExtractor = new LinuxNetworkExtractor();

       // Extract the Network Stats
        networkExtractor.NetworkPacketsExtractor();

        // Return the List
        return new NetworkMetrcis( networkExtractor.getIntefaceDatalist());
    }
}
