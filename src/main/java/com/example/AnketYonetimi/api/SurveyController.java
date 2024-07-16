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
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody SurveyRequest surveyRequest) {
        Survey survey = surveyService.createSurvey(surveyRequest.getName(), surveyRequest.getQuestionIds());
        return new ResponseEntity<>(survey, HttpStatus.CREATED);
    }


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
    public SurveyResponse getSurveyById( @PathVariable Long id ){
        return surveyService.getSurveyById(id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
    }


}
