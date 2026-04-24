package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Classification;
import com.example.demo.entity.Movie;
import com.example.demo.repository.ClassificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassificationService {

    private final ClassificationRepository classificationRepository;
    private final MovieService movieService;
    private final CategoryService categoryService;

    public List<Classification> getAllClassifications() {
        return classificationRepository.findAll();
    }

    public Classification addClassification(Long movieId, Long categoryId, LocalDate date) {
        Movie movie = movieService.getMovieById(movieId);
        Category category = categoryService.getCategoryById(categoryId);

        Classification classification = new Classification();
        classification.setMovie(movie);
        classification.setCategory(category);
        classification.setDate(date);

        return classificationRepository.save(classification);
    }

    public void deleteClassification(Long id) {
        classificationRepository.deleteById(id);
    }
}
