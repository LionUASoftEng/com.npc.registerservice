package com.npc.registerservice.commands;

import java.util.stream.Collectors;

import com.npc.registerservice.commands.Interface.ResultCommandInterface;
import org.npc.models.api.TransactionEntry;
import org.npc.models.api.TransactionEntryListing;
import org.npc.models.repositories.interfaces.TransactionEntryRepositoryInterface;

public class TransactionEntriesQuery implements ResultCommandInterface<TransactionEntryListing> {
	@Override
	public TransactionEntryListing execute() {
		return (new TransactionEntryListing()).
			setTransactionEntries(
				this.transactionEntryRepository.all().stream().map(mp -> (new TransactionEntry(mp))).collect(Collectors.toList()
			)
		);
	}

	//Properties
	private TransactionEntryRepositoryInterface transactionEntryRepository;
	public TransactionEntryRepositoryInterface getTransactionEntryRepository() {
		return this.transactionEntryRepository;
	}
	public TransactionEntriesQuery setTransactionEntryRepository(TransactionEntryRepositoryInterface transactionEntryRepository) {
		this.transactionEntryRepository = transactionEntryRepository;
		return this;
	}
}
