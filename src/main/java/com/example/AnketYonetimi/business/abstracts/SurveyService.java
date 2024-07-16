package com.example.AnketYonetimi.business.abstracts;

import com.example.AnketYonetimi.business.dto.request.SurveyRequest;
import com.example.AnketYonetimi.business.dto.response.SurveyResponse;
import com.example.AnketYonetimi.entities.Survey;

import java.util.List;

public interface SurveyService {
    Survey createSurvey(String name, List<Long> questionIds);

    List<SurveyResponse> getAllSurvey();
    SurveyResponse updateSurvey(SurveyRequest surveyRequest);
    void deleteSurvey(Long surveyId);
    SurveyResponse getSurveyById(  Long id );
}
