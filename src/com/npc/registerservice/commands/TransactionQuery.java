package com.npc.registerservice.commands;

import java.util.UUID;
import com.npc.registerservice.commands.Interface.ResultCommandInterface;
import org.npc.models.api.Transaction;
import org.npc.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionQuery implements ResultCommandInterface<Transaction> {

	@Override
	public Transaction execute() {
		return new Transaction(
			this.TransactionRepository.get(this.TransactionId));
	}

	//Properties
	private UUID TransactionId;
	public UUID getTransactionId() {
		return this.TransactionId;
	}
	public TransactionQuery setTransactionId(UUID TransactionId) {
		this.TransactionId = TransactionId;
		return this;
	}
	
	private TransactionRepositoryInterface TransactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.TransactionRepository;
	}
	public TransactionQuery setTransactionRepository(TransactionRepositoryInterface TransactionRepository) {
		this.TransactionRepository = TransactionRepository;
		return this;
	}
}

