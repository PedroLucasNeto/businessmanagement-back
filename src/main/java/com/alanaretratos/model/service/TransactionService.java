package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.Form.TransactionDTOForm;
import com.alanaretratos.model.entity.Transaction;

import jakarta.ws.rs.PathParam;

public interface TransactionService {

void createTransaction(TransactionDTOForm transactionDTO) throws Exception; 
	
	void deleteTransactionFromView(@PathParam("id") Long id) throws Exception;
	
	void updateTransaction(TransactionDTOForm transactionDTO) throws Exception;
	
	List<Transaction> listAllTransactions();
	
	Transaction getTransactionById(Long id);

	void deleteTransactionFromDB(Long id) throws Exception;
}
