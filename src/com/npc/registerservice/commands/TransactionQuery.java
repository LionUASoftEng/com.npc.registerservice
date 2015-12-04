package com.npc.registerservice.commands;

<<<<<<< HEAD
import com.npc.registerservice.commands.Interface.ResultCommandInterface;

import java.util.UUID;

=======
import java.util.UUID;
import com.npc.registerservice.commands.Interface.ResultCommandInterface;
>>>>>>> c00246d7eb8ee95cd8e8045e0b3dae80bc3e28bb
import org.npc.models.api.Transaction;
import org.npc.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionQuery implements ResultCommandInterface<Transaction> {

	@Override
	public Transaction execute() {
		return new Transaction(
<<<<<<< HEAD
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
=======
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

>>>>>>> c00246d7eb8ee95cd8e8045e0b3dae80bc3e28bb
