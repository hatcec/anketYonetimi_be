package com.example.AnketYonetimi.entities;

import com.example.AnketYonetimi.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {


    @Column(name = "questionText")
    private  String questionText;

//    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
//    private List<SurveyQuestion> surveyQuestions;

//    @ManyToOne
//    @JoinColumn(name="surveyId")
//    private Survey survey;
}
