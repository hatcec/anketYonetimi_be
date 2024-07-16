package com.example.AnketYonetimi.business.concretes;

import com.example.AnketYonetimi.business.abstracts.ParticipationService;
import com.example.AnketYonetimi.business.dto.request.ParticipationRequest;
import com.example.AnketYonetimi.business.dto.response.ParticipationResponse;
import com.example.AnketYonetimi.core.utilities.mapping.ModelMapperService;
import com.example.AnketYonetimi.dataAccess.ParticipationRepository;
import com.example.AnketYonetimi.dataAccess.SurveyRepository;
import com.example.AnketYonetimi.dataAccess.UserRepository;
import com.example.AnketYonetimi.entities.Participation;
import com.example.AnketYonetimi.entities.Survey;
import com.example.AnketYonetimi.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ParticipationManager implements ParticipationService {
    private ParticipationRepository participationRepository;
    private ModelMapperService modelMapperService;
    @Autowired
    private SurveyRepository surveyRepository;


    private UserRepository userRepository;



    public void participateInSurvey(Long surveyId, Long userId, List<String> answers) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Participation participation = new Participation();
        participation.setSurvey(survey);
        participation.setUser(user);
        participation.setAnswers(answers);
        participationRepository.save(participation);
    }

//    @Override
//    public ParticipationResponse addParticipation(ParticipationRequest participationRequest) {
//        Participation participation = this.modelMapperService.forRequest().map(participationRequest, Participation.class);
//        Participation createdParticipation = this.participationRepository.save(participation);
//        ParticipationResponse createdParticipationResponse =
//                this.modelMapperService.forResponse().map(createdParticipation, ParticipationResponse.class);
//        return createdParticipationResponse;
//    }

    @Override
    public List<ParticipationResponse> getAllParticipation() {
        List<Participation> participations = participationRepository.findAll();
        List<ParticipationResponse> participationResponses = participations.stream().map(participation -> modelMapperService.forResponse()
                .map(participation, ParticipationResponse.class)).collect(Collectors.toList());
        return participationResponses;
    }

    @Override
    public ParticipationResponse updateParticipation(ParticipationRequest participationRequest) {
        Participation  participation = this.modelMapperService.forRequest().map(participationRequest, Participation.class);
        Participation updatedParticipation = this.participationRepository.save(participation);
        ParticipationResponse updatedParticipationResponse =
                this.modelMapperService.forResponse().map(updatedParticipation, ParticipationResponse.class);
        return updatedParticipationResponse;
    }

    @Override
    public void deleteParticipation(int participationId) {
        Participation participation=participationRepository.getById(participationId);
        participationRepository.delete(participation);
    }

    @Override
    public ParticipationResponse getParticipationById(int id) {
        Participation  participation = participationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no participation for this ID."));

        ParticipationResponse response = modelMapperService.forResponse()
                .map(participation, ParticipationResponse.class);

        return response;
    }
}
