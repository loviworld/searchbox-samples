package com.lovi.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lovi.searchbox.annotation.EnableSearchBox;

/**
 * sample-app
 * @author Tharanga Thennakoon
 *
 */
@SpringBootApplication
@EnableSearchBox
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
}
