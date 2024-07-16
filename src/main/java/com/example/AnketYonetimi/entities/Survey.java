package com.example.AnketYonetimi.entities;

import com.example.AnketYonetimi.core.entities.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "surveys")
public class Survey extends BaseEntity {

    private String name;
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SurveyQuestion> surveyQuestions;

}