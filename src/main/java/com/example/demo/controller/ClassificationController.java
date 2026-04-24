package com.example.demo.controller;

import com.example.demo.entity.Classification;
import com.example.demo.service.ClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/classifications")
@RequiredArgsConstructor
public class ClassificationController {

    private final ClassificationService classificationService;

    @GetMapping
    public ResponseEntity<List<Classification>> getAllClassifications() {
        return ResponseEntity.ok(classificationService.getAllClassifications());
    }

    @PostMapping
    public ResponseEntity<Classification> addClassification(@RequestBody Map<String, Object> request) {
        Long movieId = Long.valueOf(request.get("movieId").toString());
        Long categoryId = Long.valueOf(request.get("categoryId").toString());
        LocalDate date = LocalDate.parse(request.get("date").toString());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(classificationService.addClassification(movieId, categoryId, date));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassification(@PathVariable Long id) {
        classificationService.deleteClassification(id);
        return ResponseEntity.noContent().build();
    }
}
