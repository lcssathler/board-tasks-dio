package com.dio.board_tasks;

import com.dio.board_tasks.menus.MainMenu;
import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardTasksApplication.class, args);
		new MainMenu().init();
	}

}
