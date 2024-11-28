package com.drivingschool.drivingschool.controller;

import com.drivingschool.drivingschool.entities.Lesson;
import com.drivingschool.drivingschool.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping
    private List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    @PostMapping
    private ResponseEntity<Lesson> insert(@RequestBody Lesson lesson){
        lesson = lessonRepository.save(lesson);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(lesson.getId()).toUri();
        return ResponseEntity.created(uri).body(lesson);
    }
}
