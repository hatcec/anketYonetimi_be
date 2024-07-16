package com.example.AnketYonetimi.business.concretes;

import com.example.AnketYonetimi.business.abstracts.SurveyService;
import com.example.AnketYonetimi.business.dto.request.SurveyRequest;
import com.example.AnketYonetimi.business.dto.response.QuestionResponse;
import com.example.AnketYonetimi.business.dto.response.SurveyResponse;
import com.example.AnketYonetimi.core.utilities.mapping.ModelMapperService;
import com.example.AnketYonetimi.dataAccess.QuestionRepository;
import com.example.AnketYonetimi.dataAccess.SurveyRepository;
import com.example.AnketYonetimi.entities.Question;
import com.example.AnketYonetimi.entities.Survey;
import com.example.AnketYonetimi.entities.SurveyQuestion;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SurveyManager implements SurveyService {
    private SurveyRepository surveyRepository;
    private ModelMapperService modelMapperService;
    private QuestionRepository questionRepository;
    @Override
    public void saveSelections(SurveyRequest request) {
        String name = request.getName();
        List<Question> selections = request.getQuestionIds();

        Survey selection = new Survey();
        selection.setName(name);
        selection.setQuestions(selections);

        surveyRepository.save(selection);
    }
//        Survey survey = new Survey();
//        List<Question> questions = questionRepository.findAllById(surveyRequest.getQuestionIds());
//        survey.setQuestions(questions);
//        Survey createdSurvey = this.surveyRepository.save(survey);
//        SurveyResponse createdSurveyResponse =
//                this.modelMapperService.forResponse().map(createdSurvey, SurveyResponse.class);
//        return createdSurveyResponse;

//        Survey survey = new Survey();
//        survey.setName(surveyRequest.getName());
//        survey.setCreatedDate(LocalDateTime.now());
//
//        List<SurveyQuestion> surveyQuestions = new ArrayList<>();
//        for (int questionId : surveyRequest.getQuestionIds()) {
//            Question question = questionRepository.findById(questionId)
//                    .orElseThrow(() -> new RuntimeException("Question not found: " + questionId));
//            SurveyQuestion surveyQuestion = new SurveyQuestion();
//            surveyQuestion.setSurvey(survey);
//            surveyQuestion.setQuestion(question);
//            surveyQuestions.add(surveyQuestion);
//        }
//        survey.setSurveyQuestions(surveyQuestions);

//        return surveyRepository.save(survey);
//        Survey survey = this.modelMapperService.forRequest().map(surveyRequest, Survey.class);
//        survey.setCreatedDate(LocalDateTime.now());
//
//


    @Override
    public List<SurveyResponse> getAllSurvey() {
        List<Survey> surveys = surveyRepository.findAll();
        List<SurveyResponse> surveyResponses = surveys.stream().map(survey -> modelMapperService.forResponse()
                .map(survey, SurveyResponse.class)).collect(Collectors.toList());
        return surveyResponses;
    }

    @Override
    public SurveyResponse updateSurvey(SurveyRequest surveyRequest) {
        Survey  survey = this.modelMapperService.forRequest().map(surveyRequest, Survey.class);
        Survey updatedSurvey = this.surveyRepository.save(survey);
        SurveyResponse surveyResponse =
                this.modelMapperService.forResponse().map(updatedSurvey, SurveyResponse.class);
        return surveyResponse;
    }

    @Override
    public void deleteSurvey(int surveyId) {
        Survey survey=surveyRepository.getById(surveyId);
        surveyRepository.delete(survey);
    }

    @Override
    public SurveyResponse getSurveyById(int id) {
        Survey  survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Survey for this ID."));

        SurveyResponse response = modelMapperService.forResponse()
                .map(survey, SurveyResponse.class);

        return response;
    }
}
