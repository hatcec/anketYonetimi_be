package com.example.AnketYonetimi.dataAccess;

import com.example.AnketYonetimi.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
