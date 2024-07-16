package com.example.AnketYonetimi.business.abstracts;

import com.example.AnketYonetimi.business.dto.request.ParticipationRequest;
import com.example.AnketYonetimi.business.dto.request.QuestionRequest;
import com.example.AnketYonetimi.business.dto.response.ParticipationResponse;
import com.example.AnketYonetimi.business.dto.response.QuestionResponse;

import java.util.List;

public interface ParticipationService {
    void participateInSurvey(Long surveyId, Long userId, List<String> answers);
   // ParticipationResponse addParticipation (ParticipationRequest participationRequest);
    List<ParticipationResponse> getAllParticipation();
    ParticipationResponse updateParticipation(ParticipationRequest participationRequest);
    void deleteParticipation(int participationId);
    ParticipationResponse getParticipationById(  int id );
}
