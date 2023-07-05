package com.alanaretratos.model.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.TransactionDTOForm;
import com.alanaretratos.model.entity.Transaction;
import com.alanaretratos.model.repository.TransactionRepository;
import com.alanaretratos.model.service.TransactionService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class TransactionServiceImpl implements TransactionService {

	@Inject
	TransactionRepository transactionRepository;

	@Override
	@Transactional
	public void createTransaction(TransactionDTOForm transactionDTO) throws Exception {
		Transaction transaction = new Transaction();
		
		BeanUtils.copyProperties(transaction, transactionDTO);
		transaction.setTransactionDate(LocalDate.now());
		transactionRepository.persist(transaction);
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
	@Transactional
	public void updateTransaction(TransactionDTOForm transactionDTO) throws Exception {
		Transaction transaction = transactionRepository.findByIdOptional((long) 1).orElseThrow();
		BeanUtils.copyProperties(transactionDTO, transaction);
		transaction.persist();
	}

	@Override
	@Transactional
	public void deleteTransactionFromDB(Long id) throws Exception {
		Transaction transaction = transactionRepository.findByIdOptional(id).orElseThrow();
		transactionRepository.delete(transaction);

	}

	@Override
	@Transactional
	public void deleteTransactionFromView(Long id) throws Exception {
		Transaction transaction = transactionRepository.findByIdOptional(id).orElseThrow();
		transaction.setStatus(UtilConstants.STATUS_DEACTIVATED);

		transaction.persist();

	}

}
