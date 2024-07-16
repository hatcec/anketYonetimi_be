package com.example.AnketYonetimi.entities;

import com.example.AnketYonetimi.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "participations")
public class Participation extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @ElementCollection
    private List<String> answers;
    private Role role;

}
