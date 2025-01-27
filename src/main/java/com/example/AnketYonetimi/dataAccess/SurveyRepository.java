package com.example.AnketYonetimi.dataAccess;

import com.example.AnketYonetimi.entities.Survey;
import com.example.AnketYonetimi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Optional<Survey> findById(Long  surveyId);
}
