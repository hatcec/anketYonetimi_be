package com.example.AnketYonetimi.business.abstracts;

import com.example.AnketYonetimi.business.dto.request.SurveyRequest;
import com.example.AnketYonetimi.business.dto.response.SurveyResponse;

import java.util.List;

public interface SurveyService {
    void saveSelections(SurveyRequest request);
    List<SurveyResponse> getAllSurvey();
    SurveyResponse updateSurvey(SurveyRequest surveyRequest);
    void deleteSurvey(int surveyId);
    SurveyResponse getSurveyById(  int id );
}
