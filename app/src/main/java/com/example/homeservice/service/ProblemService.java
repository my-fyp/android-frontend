package com.example.homeservice.service;

import com.example.homeservice.model.OfferModel;
import com.example.homeservice.model.ProblemModel;

import java.util.ArrayList;

public class ProblemService {
    public static ArrayList<ProblemModel> problems = new ArrayList<>();

    public static void addProblem(ProblemModel problem) {
        problems.add(problem);
    }
}
