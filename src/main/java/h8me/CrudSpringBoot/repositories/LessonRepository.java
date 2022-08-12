package h8me.CrudSpringBoot.repositories;

import h8me.CrudSpringBoot.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LessonRepository extends JpaRepository <Lesson, Integer> {
}

