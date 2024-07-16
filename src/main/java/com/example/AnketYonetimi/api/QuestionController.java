package com.example.AnketYonetimi.api;

import com.example.AnketYonetimi.business.abstracts.QuestionService;
import com.example.AnketYonetimi.business.dto.request.QuestionRequest;
import com.example.AnketYonetimi.business.dto.response.QuestionResponse;
import com.example.AnketYonetimi.business.dto.response.SurveyResponse;
import com.example.AnketYonetimi.dataAccess.SurveyRepository;
import com.example.AnketYonetimi.entities.Question;
import com.example.AnketYonetimi.entities.Survey;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/question")
public class QuestionController {
    private QuestionService questionService;
    private SurveyRepository surveyRepository;
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionResponse addQuestion( @RequestBody QuestionRequest questionRequest) {

//        Survey survey = surveyRepository.findById(questionRequest.getSurveyId()).orElseThrow();
//        questionRequest.setSurveyId(survey.getId());
        return  questionService.addQuestion(questionRequest);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionResponse> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionResponse updateQuestion(@RequestBody() QuestionRequest questionRequest) {
        return questionService.updateQuestion(questionRequest);
    }



    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionResponse getQuestionById( @PathVariable int id ){
        return questionService.getQuestionById(id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteQuestion(@PathVariable int id) {
        questionService.deleteQuestion(id);
    }
}
