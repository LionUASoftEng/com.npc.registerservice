package com.npc.registerservice.commands;

import java.util.UUID;
import com.npc.registerservice.commands.Interface.ResultCommandInterface;
import org.npc.models.api.TransactionEntry;
import org.npc.models.repositories.interfaces.TransactionEntryRepositoryInterface;

public class TransactionEntryQuery implements ResultCommandInterface<TransactionEntry> {

	@Override
	public TransactionEntry execute() {
		return new TransactionEntry(
			this.TransactionEntryRepository.get(this.TransactionEntryId));
	}

	//Properties
	private UUID TransactionEntryId;
	public UUID getTransactionEntryId() {
		return this.TransactionEntryId;
	}
	public TransactionEntryQuery setTransactionEntryId(UUID TransactionEntryId) {
		this.TransactionEntryId = TransactionEntryId;
		return this;
	}
	
	private TransactionEntryRepositoryInterface TransactionEntryRepository;
	public TransactionEntryRepositoryInterface getTransactionEntryRepository() {
		return this.TransactionEntryRepository;
	}
	public TransactionEntryQuery setTransactionEntryRepository(TransactionEntryRepositoryInterface TransactionEntryRepository) {
		this.TransactionEntryRepository = TransactionEntryRepository;
		return this;
	}
}
