package com.mywardrobe.service;

import java.util.List;

import com.mywardrobe.model.Goal;
import com.mywardrobe.model.GoalReport;

public interface GoalService {

	Goal save(Goal goal);

	List<Goal> findAllGoals();

	List<GoalReport> findAllGoalReports();
	
}
