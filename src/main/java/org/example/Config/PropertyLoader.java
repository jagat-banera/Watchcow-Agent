package org.example.Config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private final Properties properties = new Properties();

    public PropertyLoader()  {
        try(InputStream input =
                getClass().getClassLoader().getResourceAsStream("agent.properties")){
            if(input==null){
                throw new FileNotFoundException("agents.property file not found");
            }

            properties.load(input);
        }
        catch (Exception e){
            throw new RuntimeException("Failed to Load File" , e);
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public Integer getPropertyAsInteger(String key){
        return Integer.parseInt(properties.getProperty(key));
    }
}
