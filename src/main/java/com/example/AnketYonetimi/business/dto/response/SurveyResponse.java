package com.example.AnketYonetimi.business.dto.response;

import com.example.AnketYonetimi.entities.Participation;
import com.example.AnketYonetimi.entities.Question;
import com.example.AnketYonetimi.entities.SurveyQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SurveyResponse {
    private int id;
    private  String name;
    private LocalDateTime createdDate;
    private List<Question> surveyQuestions;
 //   private List<Question> questions;
    private List<Participation> participations;
}
