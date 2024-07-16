package com.example.AnketYonetimi.entities;

import com.example.AnketYonetimi.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum Role  {

    USER,
    ADMIN
}
