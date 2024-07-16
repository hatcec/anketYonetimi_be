package com.example.AnketYonetimi.api;

import com.example.AnketYonetimi.business.abstracts.SurveyService;
import com.example.AnketYonetimi.business.dto.request.SurveyRequest;
import com.example.AnketYonetimi.business.dto.response.SurveyResponse;
import com.example.AnketYonetimi.dataAccess.QuestionRepository;
import com.example.AnketYonetimi.dataAccess.SurveyQuestionRepository;
import com.example.AnketYonetimi.dataAccess.SurveyRepository;
import com.example.AnketYonetimi.entities.Question;
import com.example.AnketYonetimi.entities.Survey;
import com.example.AnketYonetimi.entities.SurveyQuestion;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/survey")
public class SurveyController {
    private SurveyService surveyService;
    private SurveyRepository surveyRepository;
    private QuestionRepository questionRepository;
    private SurveyQuestionRepository  surveyQuestionRepository;
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveSelections(@RequestBody SurveyRequest request) {
        surveyService.saveSelections(request);
        return ResponseEntity.ok("Veriler başarıyla kaydedildi");
    }
//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> createSurveyWithQuestions(@RequestBody SurveyRequest surveyRequest) {
        // Create the survey
//        Survey survey = new Survey();
//        survey.setName(surveyRequest.getName());
//        Survey savedSurvey = surveyRepository.save(survey);
//
//        // Add questions to the survey
//        List<SurveyQuestion> surveyQuestions = surveyRequest.getQuestionIds().stream()
//                .map(id -> {
//                    Question question = questionRepository.findById().orElseThrow();
//                    SurveyQuestion surveyQuestion = new SurveyQuestion();
//                    surveyQuestion.setSurvey(savedSurvey);
//                    surveyQuestion.setQuestion(question);
//                    return surveyQuestion;
//                }).collect(Collectors.toList());
//
//        surveyQuestionRepository.saveAll(surveyQuestions);
//
//        return ResponseEntity.ok("Survey and questions created successfully");
   // }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SurveyResponse> getAllSurvey() {
        return surveyService.getAllSurvey();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public SurveyResponse updateSurvey(@RequestBody() SurveyRequest surveyRequest) {
        return surveyService.updateSurvey(surveyRequest);
    }



    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SurveyResponse getSurveyById( @PathVariable int id ){
        return surveyService.getSurveyById(id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSurvey(@PathVariable int id) {
        surveyService.deleteSurvey(id);
    }


}
