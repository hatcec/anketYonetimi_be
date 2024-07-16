package com.example.AnketYonetimi.business.dto.response;

import com.example.AnketYonetimi.entities.Role;
import com.example.AnketYonetimi.entities.Survey;
import com.example.AnketYonetimi.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParticipationResponse {
    private int id;
    private User user;
    private Survey survey;
    private List<String> answers;
    private Role role;
}
