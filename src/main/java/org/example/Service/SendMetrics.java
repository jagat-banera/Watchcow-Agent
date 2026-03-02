package org.example.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Assembler.ServerMetrics;
import org.example.Config.AgentConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SendMetrics {

    private final ServerMetrics metrics ;
    private final AgentConfig agentConfig;

    public SendMetrics(ServerMetrics metrics, AgentConfig agentConfig) {
        this.metrics = metrics;
        this.agentConfig = agentConfig;
    }

    public void SendHttpRequest() throws IOException, URISyntaxException, InterruptedException {
        try {
        HttpClient client = HttpClient.newBuilder().build();
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Sending the Metrics");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(agentConfig.getServerUrl()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        mapper.writeValueAsString(
                                metrics
                        )
                )).build();



            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }

        catch (Exception e){
            e.printStackTrace();
        }


    }






}
