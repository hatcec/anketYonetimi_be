package com.example.AnketYonetimi.entities;

import com.example.AnketYonetimi.core.entities.BaseEntity;
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
//    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
//    private List<SurveyQuestion> surveyQuestions;
    @Column(name = "name")
    private  String name;
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    @ManyToMany
    @JoinTable(
            name = "survey_question",
            joinColumns = @JoinColumn(name = "survey_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
//
//    @OneToMany(mappedBy = "survey")
//    private List<Participation> participations;
//    @OneToMany(mappedBy = "survey")
//    private List<Question> questions;
}
