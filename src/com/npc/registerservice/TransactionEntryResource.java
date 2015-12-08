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

import org.npc.models.api.TransactionEntry;
import org.npc.models.api.TransactionEntryListing;
import org.npc.models.repositories.TransactionEntryRepository;
import com.npc.registerservice.commands.CreateTransactionEntryCommand;
import com.npc.registerservice.commands.TransactionEntryQuery;
import com.npc.registerservice.commands.TransactionEntryQueryByTransactionId;
import com.npc.registerservice.commands.TransactionEntriesQuery;

@Path("transactionentry/")
public class TransactionEntryResource {
	@GET
	@Path("apiv0/transactionentries")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionEntryListing getTransactionEntries() {
		return (new TransactionEntriesQuery()).
			setTransactionEntryRepository(new TransactionEntryRepository()).
			execute();
	}
	
	@GET
	@Path("apiv0/bytransactionentryid/{transactionentryid}")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionEntry getTransactionEntryQuery(@PathParam("transactionentryid") UUID transactionEntryId) {
		return (new TransactionEntryQuery()).
			setTransactionEntryId(transactionEntryId).
			setTransactionEntryRepository(new TransactionEntryRepository()).
			execute();
	}
	
	@GET
	@Path("apiv0/bytransactionid/{transactionid}")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionEntry getTransactionEntryQueryByTransactionId(@PathParam("transactionid") UUID transactionId) {
		return (new TransactionEntryQueryByTransactionId()).
			setTransactionId(transactionId).
			setTransactionEntryRepository(new TransactionEntryRepository()).
			execute();
	}
	
	@PUT
	@Path("apiv0")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionEntry createTransactionEntry(JAXBElement<TransactionEntry> apiTransactionEntry) {
		return (new CreateTransactionEntryCommand()).
			setApiTransactionEntry(apiTransactionEntry.getValue()).
			setTransactionEntryRepository(new TransactionEntryRepository()).
			execute();
	}
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Successful TransactionEntry test (.../test/)";
	}
}

