package com.npc.registerservice.commands;

import com.npc.registerservice.commands.Interface.ResultCommandInterface;

import org.apache.commons.lang3.StringUtils;
import org.npc.models.api.Transaction;
import org.npc.models.enums.TransactionApiRequestStatus;
import org.npc.models.repositories.interfaces.TransactionRepositoryInterface;

public class CreateTransactionCommand implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {
		if (StringUtils.isBlank(this.apiTransaction.getTransactionType().toString()) 
			|| StringUtils.isBlank(this.apiTransaction.getCashierid().toString()) ) {
			return (new Transaction()).setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT);
		}
		return this.apiTransaction;
	}
	
	//Properties
	private Transaction apiTransaction;
	public Transaction getApiTransaction(){
		return this.apiTransaction;
	}
	public CreateTransactionCommand setApiTransaction(Transaction apiTransaction){
		this.apiTransaction = apiTransaction;
		return this;
	}
	
	private TransactionRepositoryInterface TransactionRepository;
	public TransactionRepositoryInterface getTransactionRepository(){
		return this.TransactionRepository;
	}
	public CreateTransactionCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository){
		this.TransactionRepository = transactionRepository;
		return this;
	}	
}
