package com.npc.registerservice;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.npc.models.api.Transaction;
import org.npc.models.repositories.TransactionRepository;
import com.npc.registerservice.commands.CreateTransactionCommand;
import com.npc.registerservice.commands.TransactionQuery;

@Path("transaction/")
public class TransactionResource {
	
	@PUT
	@Path("apiv0")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction createTransaction(JAXBElement<Transaction> apiTransaction){
		return (new CreateTransactionCommand()).
				setApiTransaction(apiTransaction.getValue()).
				setTransactionRepository(new TransactionRepository()).execute();
	}
	
	@GET
	@Path("apiv0/byTransactionid/{Transactionid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction getTransactionQuery(@PathParam("Transactionid") UUID TransactionId) {
		return (new TransactionQuery()).
			setTransactionId(TransactionId).
			setTransactionRepository(new TransactionRepository()).
			execute();
	}
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Successful transaction test (.../test/)";
	}

}
