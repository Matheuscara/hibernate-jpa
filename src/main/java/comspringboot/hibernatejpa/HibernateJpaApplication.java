package comspringboot.hibernatejpa;

import comspringboot.hibernatejpa.dao.StudentDAO;
import comspringboot.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaApplication.class, args);
    }

    // functions after project initial
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            removeAllStudents(studentDAO);

            System.out.println("Lets goo, project init");
        };
    }

    // Create a method to return index of user
    private Student readStudant(StudentDAO studentDAO) {

        // retrieve student based on the id: primary key
        return studentDAO.findById(1);
    }

    // testing index saving in my application
    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 student");
        Student student1 = new Student("ggg", "ggg", "ggg@gmail.com");
        Student student2 = new Student("tes1", "aa", "bb@gmail.com");
        Student student3 = new Student("tes2", "vv", "aa@gmail.com");

        System.out.println("Saving all the students");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void removeStudent(StudentDAO studentDAO) {
        int studentId = 2;
        System.out.println("Deleting student");

        studentDAO.remove(studentId);
    }

    private void removeAllStudents(StudentDAO studentDAO) {
        System.out.println("Removing all students");
        studentDAO.removeAll();
        System.out.println("All students removed");
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retriever student based onm the id: primary key
        int studentId = 1;
        System.out.println("Updating student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Scooby"
        System.out.println("Change first the user with id: " + myStudent.getId());
        myStudent.setFirstName("Scooby");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    // Create a method to return all students
    private List<Student> readMultipleStudents(StudentDAO studentDAO) {
        return studentDAO.findAll();
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
