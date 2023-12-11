package com.charan.quiz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle,option1,option2,option3,option4,rightAnswer,difficultylevel,category;


}
