package com.npc.registerservice.commands;

import com.npc.registerservice.commands.Interface.ResultCommandInterface;

import java.util.UUID;

import org.npc.models.api.Transaction;
import org.npc.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionQuery implements ResultCommandInterface<Transaction> {

	@Override
	public Transaction execute() {
		return new Transaction(
			this.transactionRepository.get(this.transactionId));
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public TransactionQuery setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
}
