package com.npc.registerservice.commands;

import java.util.UUID;
import com.npc.registerservice.commands.Interface.ResultCommandInterface;
import org.npc.models.api.TransactionEntry;
import org.npc.models.repositories.interfaces.TransactionEntryRepositoryInterface;

public class TransactionEntryQueryByTransactionId implements ResultCommandInterface<TransactionEntry> {

	@Override
	public TransactionEntry execute() {
		return new TransactionEntry(
			this.TransactionEntryRepository.byTransactionId(transactionId));
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public TransactionEntryQueryByTransactionId setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private TransactionEntryRepositoryInterface TransactionEntryRepository;
	public TransactionEntryRepositoryInterface getTransactionEntryRepository() {
		return this.TransactionEntryRepository;
	}
	public TransactionEntryQueryByTransactionId setTransactionEntryRepository(TransactionEntryRepositoryInterface TransactionEntryRepository) {
		this.TransactionEntryRepository = TransactionEntryRepository;
		return this;
	}
}
