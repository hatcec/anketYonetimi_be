package com.example.AnketYonetimi.business.concretes;

import com.example.AnketYonetimi.business.abstracts.QuestionService;
import com.example.AnketYonetimi.business.dto.request.QuestionRequest;
import com.example.AnketYonetimi.business.dto.response.ParticipationResponse;
import com.example.AnketYonetimi.business.dto.response.QuestionResponse;
import com.example.AnketYonetimi.core.utilities.mapping.ModelMapperService;
import com.example.AnketYonetimi.dataAccess.ParticipationRepository;
import com.example.AnketYonetimi.dataAccess.QuestionRepository;
import com.example.AnketYonetimi.dataAccess.SurveyRepository;
import com.example.AnketYonetimi.entities.Participation;
import com.example.AnketYonetimi.entities.Question;
import com.example.AnketYonetimi.entities.Survey;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class QuestionManager implements QuestionService {
    private QuestionRepository questionRepository;
    private ModelMapperService modelMapperService;
    private SurveyRepository surveyRepository;
    @Override
    public QuestionResponse addQuestion(QuestionRequest questionRequest) {
        Question question = this.modelMapperService.forRequest().map(questionRequest, Question.class);

//        Survey survey=surveyRepository.findById(questionRequest.getSurveyId()).orElseThrow();
//       question.setSurvey(survey);
        Question createdQuestion = this.questionRepository.save(question);
        QuestionResponse createdQuestionResponse =
                this.modelMapperService.forResponse().map(createdQuestion, QuestionResponse.class);
        return createdQuestionResponse;
//        Question question = this.modelMapperService.forRequest().map(questionRequest, Question.class);
//        Question createdQuestion = this.questionRepository.save(question);
//        QuestionResponse createdQuestionResponse =
//                this.modelMapperService.forResponse().map(createdQuestion, QuestionResponse.class);
//        return createdQuestionResponse;
    }

    @Override
    public List<QuestionResponse> getAllQuestion() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionResponse> questionResponses = questions.stream().map(question -> modelMapperService.forResponse()
                .map(question, QuestionResponse.class)).collect(Collectors.toList());
        return questionResponses;
    }

    @Override
    public QuestionResponse updateQuestion(QuestionRequest questionRequest) {
        Question  question = this.modelMapperService.forRequest().map(questionRequest, Question.class);
        Question updatedQuestion = this.questionRepository.save(question);
        QuestionResponse questionResponse =
                this.modelMapperService.forResponse().map(updatedQuestion, QuestionResponse.class);
        return questionResponse;
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question=questionRepository.getById(questionId);
        questionRepository.delete(question);
    }

    @Override
    public QuestionResponse getQuestionById(Long id) {
        Question  question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Question for this ID."));

        QuestionResponse response = modelMapperService.forResponse()
                .map(question, QuestionResponse.class);

        return response;
    }
}
