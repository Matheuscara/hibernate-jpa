package comspringboot.hibernatejpa.dao;

import comspringboot.hibernatejpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student TheStudant);

    Student findById(int id);

    List<Student> findAll();

    void update(Student TheStudant);

    void remove(Integer id);

    void removeAll();
}
