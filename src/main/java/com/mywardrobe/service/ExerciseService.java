package com.mywardrobe.service;

import java.util.List;

import com.mywardrobe.model.Activity;
import com.mywardrobe.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);

}