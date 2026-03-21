package com.example.JPA;

import com.example.JPA.Task.DAO;
import com.example.JPA.Task.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;


@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DAO dao){
		return runner->{
 			updateTask(dao);
		};
	}

	private void updateTask(DAO dao) {
		dao.updateById(8,"Task has been updated here");
		System.out.println("Task has been updated here");
	}

	private void patchDelete(DAO dao) {
		int arr[]={4,5};
		dao.patchDeleted(arr);
	}


	private void findTask(DAO dao) {
		Task myTask= dao.findById(1);
		System.out.println("Task : "+ myTask);
	}

	private void addTask(DAO dao) {
		System.out.println("Adding task...");
		Task task1= new Task(LocalDate.of(2026,3,17),"Completed JPA by doing the delete, update, patch delete", LocalTime.of(6,30),LocalTime.of(7,22));
		dao.save(task1);
		System.out.println("Added task...");
	}

	public static void deleteById(DAO dao){
		System.out.println("Deleting the tasks");
		dao.deletedById(6);
		System.out.println("Deleted the tasks");
	}

}
