package com.alanaretratos.model.serviceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import com.alanaretratos.model.repository.BookingRepository;
import com.alanaretratos.model.repository.BudgetRepository;
import com.alanaretratos.model.repository.TransactionRepository;
import com.alanaretratos.model.service.DashboardService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DashboardServiceImpl implements DashboardService{
	
	@Inject
	BudgetRepository budgetRepository;
	
	@Inject
	BookingRepository bookingRepository;
	
	@Inject
	TransactionRepository transactionRepository;

	@Override
	public double monthlyIncome() {
		
		return transactionRepository.monthlyIncome();
	}

	@Override
	public double periodIncome(LocalDate startingDate, LocalDate endingDate) {
		
		return 0;
	}

	@Override
	public double monthyOutcome() {
		
		return 0;
	}

	@Override
	public double periodOutcome(LocalDate startingDate, LocalDate endingDate) {
		
		return 0;
	}

	@Override
	public double monthlySalesConversion() {
		
		return transactionRepository.monthlyIncome();
		
	}

	@Override
	public double periodSalesConversion() {
		
		return 0;
	}
	
	@Override
	public int monthlyBookings() {
		return 	bookingRepository.findMonthlyBookings();
	}
	
	@Override
	public int monthlyBudgets() {
		return budgetRepository.findMonthlyBookings();

	}

}
