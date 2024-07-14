package com.OMTBP.OMTBP;

import com.OMTBP.OMTBP.service.Platform;
import com.OMTBP.OMTBP.service.PlatformImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OmtbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmtbpApplication.class, args);
	}

	@Bean
	public Platform getPlatform() {
		return new PlatformImpl();
	}

}
