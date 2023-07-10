package com.alanaretratos.model.service;

import java.time.LocalDate;

public interface DashboardService {
	
	double monthlyIncome();
	
	double periodIncome(LocalDate startingDate, LocalDate endingDate);
	
	double monthyOutcome();
	
	double periodOutcome(LocalDate startingDate, LocalDate endingDate);
	
	double monthlySalesConversion();
	
	double periodSalesConversion();
	
	int monthlyBookings();
	
	int monthlyBudgets();


}
