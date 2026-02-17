package org.example.Config;

import java.io.ObjectInputFilter;

public class AgentConfig {

    private final String agentId ;
    private final String version ;
    private final int intervalSeconds;
    private final String serverUrl ;


    public AgentConfig(PropertyLoader propertyLoader) {
        this.agentId = propertyLoader.getProperty("agent.id");
        this.version = propertyLoader.getProperty("agent.version");
        this.intervalSeconds = propertyLoader.getPropertyAsInteger("agent.interval.seconds");
        this.serverUrl = propertyLoader.getProperty("server.url");
    }

    public String getAgentId() {
        return agentId;
    }

    public String getVersion() {
        return version;
    }

    public int getIntervalSeconds() {
        return intervalSeconds;
    }

    public String getServerUrl() {
        return serverUrl;
    }
}
