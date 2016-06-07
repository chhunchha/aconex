package com.aconex.cost.contract.controllers;

import com.aconex.cost.contract.services.ContractService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/contracts")
@Produces(MediaType.APPLICATION_JSON)
public class ContractsController {

    private final ContractService contractService;

    public ContractsController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GET
    @UnitOfWork
    public Response index() {
        return Response.ok(contractService.findAll()).build();
    }
}
