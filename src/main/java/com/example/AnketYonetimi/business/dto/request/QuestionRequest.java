package com.example.AnketYonetimi.business.dto.request;

import com.example.AnketYonetimi.entities.Survey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionRequest {
   // private int surveyId;
    private  int id;
    private  String questionText;
}
