package com.aconex.cost.contract.controllers;

import com.aconex.cost.contract.models.Contract;
import com.aconex.cost.contract.models.Project;
import com.aconex.cost.contract.services.ContractService;
import com.aconex.cost.contract.services.ProjectService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectsController {

    private final ProjectService projectService;

    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GET
    @UnitOfWork
    public Response index() {
        return Response.ok(projectService.findAll()).build();
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public Project getProject(@PathParam("id") long id) {
        return projectService.getProject(id);
    }

    @GET
    @UnitOfWork
    @Path("/code/{code}")
    public List<Project> findProjectByCode(@PathParam("code") String code) {
        return projectService.findProjectByCode(code);
    }

    @POST
    @UnitOfWork
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Project saveOrUpdate(Project project) {
        return projectService.saveOrUpdate(project);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public void deleteProject(@PathParam("id")  long id) throws Exception {
        try {
            projectService.deleteProject(id);
        } catch(Exception e) {
            throw new Exception("Project not found.");
        }
    }
}
