package h8me.CrudSpringBoot.services;

import h8me.CrudSpringBoot.models.Lesson;
import h8me.CrudSpringBoot.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LessonService {


    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;

    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson findOne(int id) {
        Optional<Lesson> foundLabel = lessonRepository.findById(id);
        return foundLabel.orElse(null);
    }

    @Transactional
    public void save(Lesson lesson) {

        lessonRepository.save(lesson);
    }

    @Transactional
    public void update(int id, Lesson updatedLesson) {
        updatedLesson.setId(id);
        lessonRepository.save(updatedLesson);
    }

    @Transactional
    public void delete(int id) {
        lessonRepository.deleteById(id);
    }


}
