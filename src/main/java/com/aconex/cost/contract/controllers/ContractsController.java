package com.aconex.cost.contract.controllers;

import com.aconex.cost.contract.services.ContractService;
import com.aconex.cost.contract.views.ContractsView;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/contracts")
@Produces(MediaType.TEXT_HTML)
public class ContractsController {

    private final ContractService contractService;

    public ContractsController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GET
    @UnitOfWork
    public ContractsView index() {
        return new ContractsView(contractService.findAll());
    }
}
