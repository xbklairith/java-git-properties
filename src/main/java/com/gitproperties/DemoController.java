package com.gitproperties;
import java.io.IOException;
import java.util.Properties;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {
	
	@RequestMapping("/")
    String home() {

    	Properties properties = new Properties();
    	try{
        	properties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));
		}	
		catch(IOException ex){
			return "Cannot load properties file";
		}
        return properties.toString();

    }
}