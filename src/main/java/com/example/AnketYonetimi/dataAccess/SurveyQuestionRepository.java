package com.example.AnketYonetimi.dataAccess;

import com.example.AnketYonetimi.entities.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Integer> {
}
