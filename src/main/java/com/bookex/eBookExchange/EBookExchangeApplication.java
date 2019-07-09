package com.bookex.eBookExchange;

import com.bookex.eBookExchange.FileUploader.Property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class EBookExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBookExchangeApplication.class, args);
	}

}
