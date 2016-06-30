package com.mywardrobe.repository;


import java.util.List;

import com.mywardrobe.model.Goal;
import com.mywardrobe.model.GoalReport;

public interface GoalRepository {

	Goal save(Goal goal);

	List<Goal> loadAll();

	List<GoalReport> findAllGoalReports();
	
}
