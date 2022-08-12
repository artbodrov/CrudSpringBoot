package h8me.CrudSpringBoot.services;

import h8me.CrudSpringBoot.models.Course;
import h8me.CrudSpringBoot.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CourseServise {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServise(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findOne(int id) {
        Optional<Course> foundLabel = courseRepository.findById(id);
        return foundLabel.orElse(null);
    }

    @Transactional
    public void save(Course course) {

        courseRepository.save(course);
    }

    @Transactional
    public void update(int id, Course updatedCourse) {
        updatedCourse.setId(id);
        courseRepository.save(updatedCourse);
    }

    @Transactional
    public void delete(int id) {
        courseRepository.deleteById(id);
    }
}
