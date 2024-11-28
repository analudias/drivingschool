package com.drivingschool.drivingschool.repositories;

import com.drivingschool.drivingschool.entities.Lesson;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Id> {
}
