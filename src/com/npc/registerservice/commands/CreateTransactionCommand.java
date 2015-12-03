package com.npc.registerservice.commands;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.models.api.Transaction;
import org.npc.models.enums.TransactionApiRequestStatus;
import org.npc.models.repositories.interfaces.TransactionRepositoryInterface;

import com.npc.registerservice.commands.Interface.ResultCommandInterface;

public class CreateTransactionCommand implements ResultCommandInterface<Transaction> {

	@Override
	public Transaction execute() {
		
		return new Transaction(this.transactionRepository.get(this.transactionID));
	}
																	
		//Properties
		private Transaction apiTransaction;
		public Transaction getApiTransaction() {
			return this.apiTransaction;
		}
		public CreateTransactionCommand setApiTransaction(Transaction apiTransaction) {
			this.apiTransaction = apiTransaction;
			return this;
		}
		
		private UUID transactionID;
		
		private TransactionRepositoryInterface transactionRepository;
		public TransactionRepositoryInterface getTransactionRepository() {
			return this.transactionRepository;
		}
		public CreateTransactionCommand setTransactionRepository(TransactionRepositoryInterface productRepository) {
			this.transactionRepository = transactionRepository;
			return this;
		}
}
		
