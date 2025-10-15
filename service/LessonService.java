package com.olp.service;

import com.olp.dto.LessonDTO;
import java.util.List;

public interface LessonService {
    LessonDTO createLesson(LessonDTO lessonDTO);
    LessonDTO getLessonById(Long id);
    List<LessonDTO> getLessonsByCourse(Long courseId);
    LessonDTO updateLesson(Long id, LessonDTO lessonDTO);
    void deleteLesson(Long id);
}
