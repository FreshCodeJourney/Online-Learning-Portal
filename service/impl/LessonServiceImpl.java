package com.olp.service.impl;

import com.olp.dto.LessonDTO;
import com.olp.entity.Course;
import com.olp.entity.Lesson;
import com.olp.exception.ResourceNotFoundException;
import com.olp.repository.CourseRepository;
import com.olp.repository.LessonRepository;
import com.olp.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Course course = courseRepository.findById(lessonDTO.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + lessonDTO.getCourseId()));

        Lesson lesson = new Lesson();
        lesson.setTitle(lessonDTO.getTitle());
        lesson.setContent(lessonDTO.getContent());
        lesson.setVideoUrl(lessonDTO.getVideoUrl());
        lesson.setDuration(lessonDTO.getDuration());
        lesson.setCourse(course);

        Lesson savedLesson = lessonRepository.save(lesson);
        return mapToDTO(savedLesson);
    }

    @Override
    public LessonDTO getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with ID: " + id));
        return mapToDTO(lesson);
    }

    @Override
    public List<LessonDTO> getLessonsByCourse(Long courseId) {
        return lessonRepository.findByCourseId(courseId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LessonDTO updateLesson(Long id, LessonDTO lessonDTO) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with ID: " + id));

        lesson.setTitle(lessonDTO.getTitle());
        lesson.setContent(lessonDTO.getContent());
        lesson.setVideoUrl(lessonDTO.getVideoUrl());
        lesson.setDuration(lessonDTO.getDuration());

        Lesson updatedLesson = lessonRepository.save(lesson);
        return mapToDTO(updatedLesson);
    }

    @Override
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lesson not found with ID: " + id);
        }
        lessonRepository.deleteById(id);
    }

    private LessonDTO mapToDTO(Lesson lesson) {
        return new LessonDTO(
                lesson.getId(),
                lesson.getTitle(),
                lesson.getContent(),
                lesson.getVideoUrl(),
                lesson.getDuration(),
                lesson.getCourse().getId()
        );
    }
}
