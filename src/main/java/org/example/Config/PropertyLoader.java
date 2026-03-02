package org.example.Config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private final Properties properties = new Properties();

    public PropertyLoader(){
        FilePropertyLoader();
        OverrideSystemProperties();
    }

    public void FilePropertyLoader()  {

        try(InputStream input =
                getClass().getClassLoader().getResourceAsStream("agent.properties")){
            if(input==null){
                throw new FileNotFoundException("agents.property file not found");
            }

            properties.load(input);
            System.out.println("Property : " + properties.getProperty("server.url"));
        }
        catch (Exception e){
            throw new RuntimeException("Failed to Load File" , e);
        }
    }


    public void OverrideSystemProperties(){

        //  System Property Overide
        String ingestionUrl = System.getProperty("server.url");
        if(ingestionUrl != null){
            properties.setProperty("server.url",ingestionUrl);
            System.out.println("Property : " + properties.getProperty("server.url"));
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public Integer getPropertyAsInteger(String key){
        return Integer.parseInt(properties.getProperty(key));
    }
}
