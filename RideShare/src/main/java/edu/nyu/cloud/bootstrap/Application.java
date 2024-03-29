package edu.nyu.cloud.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * This class is used to bootstrap the application.
 * 
 * @author rahulkhanna
 * Date:05-Apr-2016
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "edu.nyu.cloud")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}