package comspringboot.hibernatejpa;

import comspringboot.hibernatejpa.dao.StudentDAO;
import comspringboot.hibernatejpa.dao.StudentDAOImpl;
import comspringboot.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaApplication.class, args);
    }

    // functions after project initial
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

            createStudent(studentDAO);

            System.out.println("Lets goo, project init");
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating student");
        Student student = new Student("Paul", "Dias", "paul@gmail.com");

        // save the student object
        System.out.println("Student created");
        System.out.println("Saving student");
        studentDAO.save(student);

        // display od of the saved student
        System.out.println("Student saved. Generated id: " + student.getId());
    }

}
