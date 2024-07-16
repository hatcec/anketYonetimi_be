package com.example.AnketYonetimi.business.abstracts;

import com.example.AnketYonetimi.business.dto.request.QuestionRequest;
import com.example.AnketYonetimi.business.dto.request.SurveyRequest;
import com.example.AnketYonetimi.business.dto.response.QuestionResponse;
import com.example.AnketYonetimi.business.dto.response.SurveyResponse;

import java.util.List;

public interface QuestionService {
    QuestionResponse addQuestion (QuestionRequest questionRequest);
    List<QuestionResponse> getAllQuestion();
    QuestionResponse updateQuestion(QuestionRequest questionRequest);
    void deleteQuestion(int questionId);
    QuestionResponse getQuestionById(  int id );
}
