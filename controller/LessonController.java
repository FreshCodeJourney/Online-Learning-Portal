package com.olp.controller;

import com.olp.dto.LessonDTO;
import com.olp.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/olp/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/add")
    public ResponseEntity<LessonDTO> createLesson(@RequestBody LessonDTO lessonDTO) {
        return ResponseEntity.ok(lessonService.createLesson(lessonDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<LessonDTO> getLessonById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<LessonDTO>> getLessonsByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(lessonService.getLessonsByCourse(courseId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LessonDTO> updateLesson(@PathVariable Long id, @RequestBody LessonDTO lessonDTO) {
        return ResponseEntity.ok(lessonService.updateLesson(id, lessonDTO));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok("Lesson deleted successfully");
    }
}
