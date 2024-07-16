package com.example.AnketYonetimi.business.dto.request;

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
public class ParticipationRequest {
    private int id;
    private User user;
    private int survey;
    private List<String> answers;
    private Role role;
}
