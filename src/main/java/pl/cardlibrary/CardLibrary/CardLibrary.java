package pl.cardlibrary.CardLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.desktop.UserSessionEvent;

@SpringBootApplication
public class CardLibrary {
	public static void main(String[] args) {
		SpringApplication.run(CardLibrary.class, args);
	}

}
