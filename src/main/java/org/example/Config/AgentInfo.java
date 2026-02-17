package org.example.Config;

import java.net.Inet4Address;
import java.net.InetAddress;

public record AgentInfo (
        String agentId ,
        String hostname,
        String version
) {

}
