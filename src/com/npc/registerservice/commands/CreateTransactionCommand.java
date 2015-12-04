package com.npc.registerservice.commands;

<<<<<<< HEAD
=======
import com.npc.registerservice.commands.Interface.ResultCommandInterface;

>>>>>>> c00246d7eb8ee95cd8e8045e0b3dae80bc3e28bb
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.models.api.Transaction;
import org.npc.models.enums.TransactionApiRequestStatus;
import org.npc.models.repositories.interfaces.TransactionRepositoryInterface;

<<<<<<< HEAD
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
		
=======
public class CreateTransactionCommand implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {
		if (StringUtils.isBlank(this.apiTransaction.getTransactionType().toString()) 
			|| StringUtils.isBlank(this.apiTransaction.getCashierid().toString()) ) {
			return (new Transaction()).setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT);
		}
		
		this.apiTransaction.setId(UUID.randomUUID());
		org.npc.models.Transaction modelTransaction = new org.npc.models.Transaction(this.apiTransaction);
		
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
>>>>>>> c00246d7eb8ee95cd8e8045e0b3dae80bc3e28bb
