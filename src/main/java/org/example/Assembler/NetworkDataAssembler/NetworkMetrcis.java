package org.example.Assembler.NetworkDataAssembler;

import org.example.Config.AgentConfig;
import org.example.Config.AgentInfo;
import org.example.Config.PropertyLoader;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class NetworkMetrcis {


    private final List<NetworkIntefaceData> intefaceData ;


    public NetworkMetrcis(List<NetworkIntefaceData> intefaceData) throws UnknownHostException {



        // Get this form constructor
        this.intefaceData = intefaceData;
    }
    
    public List<NetworkIntefaceData> getIntefaceData() {
        return intefaceData;
    }

}
