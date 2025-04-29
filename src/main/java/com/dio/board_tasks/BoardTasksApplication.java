package com.dio.board_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BoardTasksApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BoardTasksApplication.class, args);

		MainMenu menu = context.getBean(MainMenu.class);
		menu.init();
	}

}
