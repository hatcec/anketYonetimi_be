package com.example.AnketYonetimi.dataAccess;

import com.example.AnketYonetimi.entities.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, Integer> {
}
