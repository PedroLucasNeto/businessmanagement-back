package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.TransactionDTO;
import com.alanaretratos.model.entity.Transaction;
import com.alanaretratos.model.repository.TransactionRepository;
import com.alanaretratos.model.service.TransactionService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class TransactionServiceImpl implements TransactionService {

	@Inject
	TransactionRepository transactionRepository;

	@Override
	public void createTransaction(TransactionDTO transactionDTO) throws Exception {
		Transaction transaction = transactionRepository.findById(transactionDTO.getId());
		if (transaction.equals(null)) {

			transaction.setAmount(transactionDTO.getAmount());
			transaction.setClient(transactionDTO.getClient());
			transaction.setDescription(transactionDTO.getDescription());
			transaction.setOrigin(transactionDTO.getOrigin());
			transaction.setPaymentDate(transactionDTO.getPaymentDate());
			transaction.setTransactionDate(transactionDTO.getTransactionDate());
			transaction.setTransactionType(transactionDTO.getTransactionType());

			transaction.persist();
		} else {
			throw new Exception("Couldn't create this Transaction");
		}

	}

	@Override
	public List<Transaction> listAllTransactions() {
		return transactionRepository.findAllActivated();
	}

	@Override
	public Transaction getTransactionById(Long id) {
		Transaction transaction = transactionRepository.findByIdOptional(id).orElseThrow();
		return transaction;
	}

	@Override
	public void updateTransaction(TransactionDTO transactionDTO) throws Exception {
		Transaction transaction = transactionRepository.findByIdOptional(transactionDTO.getId()).orElseThrow();
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setClient(transactionDTO.getClient());
		transaction.setDescription(transactionDTO.getDescription());
		transaction.setOrigin(transactionDTO.getOrigin());
		transaction.setPaymentDate(transactionDTO.getPaymentDate());
		transaction.setTransactionDate(transactionDTO.getTransactionDate());
		transaction.setTransactionType(transactionDTO.getTransactionType());
		transaction.persist();
	}

	@Override
	public void deleteTransactionFromDB(Long id) throws Exception {
		Transaction transaction = transactionRepository.findByIdOptional(id).orElseThrow();
		transactionRepository.delete(transaction);

	}

	@Override
	public void deleteTransactionFromView(Long id) throws Exception {
		Transaction transaction = transactionRepository.findByIdOptional(id).orElseThrow();
		transaction.setStatus(UtilConstants.STATUS_DEACTIVATED);

		transaction.persist();

	}

}
