package org.example.Config;

import org.example.CustomExceptions.PropertyFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final Logger logger = LoggerFactory.getLogger(PropertyLoader.class.toString());

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
        }
        catch (Exception e){
            throw new PropertyFileException("Failed to Load File" , e);
        }
    }


    public void OverrideSystemProperties(){

        //  System Property Overide
        String ingestionUrl = System.getProperty("server.url");
        if(ingestionUrl != null){
            properties.setProperty("server.url",ingestionUrl);

        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public Integer getPropertyAsInteger(String key){
        return Integer.parseInt(properties.getProperty(key));
    }
}
