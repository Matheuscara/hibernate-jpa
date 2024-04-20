package comspringboot.hibernatejpa.dao;
import comspringboot.hibernatejpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    // Using transactional annotation here because going a change request in database
    public void save(Student theStudant) {
        entityManager.persist(theStudant);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
        List<Student> students = theQuery.getResultList();
        return students;
    }

    @Override
    @Transactional
    // Using transactional annotation here because going a change request in database
    public void update(Student TheStudant) {
        entityManager.merge(TheStudant);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public void removeAll() {
        // executableupdate() = modify in database query
        entityManager.createQuery("delete from Student").executeUpdate();
    }
}
