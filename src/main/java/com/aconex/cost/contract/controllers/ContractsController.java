package com.aconex.cost.contract.controllers;

import com.aconex.cost.contract.models.Contract;
import com.aconex.cost.contract.services.ContractService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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

    @GET
    @UnitOfWork
    @Path("/{id}")
    public Contract getContract(@PathParam("id") long id) {
        return contractService.getContract(id);
    }

    @GET
    @UnitOfWork
    @Path("/code/{code}")
    public List<Contract> findContractByCode(@PathParam("code") String code) {
        return contractService.findContractByCode(code);
    }

    @POST
    @UnitOfWork
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Contract saveOrUpdate(Contract contract) {
        return contractService.saveOrUpdate(contract);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public void deleteContract(@PathParam("id")  long id) throws Exception {
        try {
            contractService.deleteContract(id);
        } catch(Exception e) {
            throw new Exception("Contract not found.");
        }
    }
}
