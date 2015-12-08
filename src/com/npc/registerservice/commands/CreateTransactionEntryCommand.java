package com.npc.registerservice.commands;

import com.npc.registerservice.commands.Interface.ResultCommandInterface;

import org.apache.commons.lang3.StringUtils;
import org.npc.models.api.TransactionEntry;
import org.npc.models.enums.TransactionEntryApiRequestStatus;
import org.npc.models.repositories.interfaces.TransactionEntryRepositoryInterface;

public class CreateTransactionEntryCommand implements ResultCommandInterface<TransactionEntry> {
	@Override
	public TransactionEntry execute() {
		if (StringUtils.isBlank(this.apiTransactionEntry.getTransactionId().toString()) 
			|| StringUtils.isBlank(this.apiTransactionEntry.getProductId().toString()) ) {
			return (new TransactionEntry()).setApiRequestStatus(TransactionEntryApiRequestStatus.INVALID_INPUT);
		}
		return this.apiTransactionEntry;
	}
	
	//Properties
	private TransactionEntry apiTransactionEntry;
	public TransactionEntry getApiTransactionEntry(){
		return this.apiTransactionEntry;
	}
	public CreateTransactionEntryCommand setApiTransactionEntry(TransactionEntry apiTransactionEntry){
		this.apiTransactionEntry = apiTransactionEntry;
		return this;
	}
	
	private TransactionEntryRepositoryInterface TransactionEntryRepository;
	public TransactionEntryRepositoryInterface getTransactionEntryRepository(){
		return this.TransactionEntryRepository;
	}
	public CreateTransactionEntryCommand setTransactionEntryRepository(TransactionEntryRepositoryInterface transactionRepository){
		this.TransactionEntryRepository = transactionRepository;
		return this;
	}	
}