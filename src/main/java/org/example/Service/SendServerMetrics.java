package org.example.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Assembler.ServerMetrics;
import org.example.Config.AgentConfig;

import org.example.CustomExceptions.InjectorNotFoundExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SendServerMetrics {

    private final ServerMetrics metrics ;
    private final AgentConfig agentConfig;

    private static final Logger logger = LoggerFactory.getLogger(SendServerMetrics.class.toString());

    public SendServerMetrics(ServerMetrics metrics, AgentConfig agentConfig) {
        this.metrics = metrics;
        this.agentConfig = agentConfig;
    }

    public void SendHttpRequest() throws InjectorNotFoundExeption , IOException, URISyntaxException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().build();
        ObjectMapper mapper = new ObjectMapper();



        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(agentConfig.getServerUrl()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        mapper.writeValueAsString(
                                metrics
                        )
                )).build();

            logger.debug("Sending Metrics to Injector....");

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

            // Throw an Error when tha response is not 200
            if (response.statusCode() != 200){
                throw new InjectorNotFoundExeption("Injector Response " + response.statusCode());
            }
            else {
                logger.debug("Metrics Sent Successfully");
            }

    }






}
