package com.moodverse;

import com.moodverse.dao.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoodverseApplication {

	static void createTables() {
		UserRepository.getUserRepository().createTable();
		AmbienceRepository.getAmbienceRepository().createTable();
		BackgroundRepository.getBackgroundRepository().createTable();
		DailyQuoteRepository.getDailyQuoteRepository().createTable();
		StreakRepository.getStreakRepository().createTable();
		TaskRepository.getTaskRepository().createTable();
		TimerRepository.getTimerRepository().createTable();
		ToDoListRepository.getToDoListRepository().createTable();
	}

	public static void main(String[] args) {

		SpringApplication.run(MoodverseApplication.class, args);
		createTables();

	}

}

