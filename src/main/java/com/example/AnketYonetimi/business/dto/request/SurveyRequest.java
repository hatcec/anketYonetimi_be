package com.example.AnketYonetimi.business.dto.request;

import com.example.AnketYonetimi.entities.Participation;
import com.example.AnketYonetimi.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SurveyRequest {
    private String name;
    private List<Long> questionIds;
    private LocalDateTime createdDate;

}
