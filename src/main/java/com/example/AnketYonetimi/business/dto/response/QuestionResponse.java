package com.example.AnketYonetimi.business.dto.response;

import com.example.AnketYonetimi.entities.Survey;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionResponse {
    //private Survey surveyId;
    private int id;
    private  String questionText;
}
