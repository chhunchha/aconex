package com.aconex.cost.contract.repositories;

import com.aconex.cost.contract.models.Contract;
import com.aconex.cost.contract.models.Project;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ProjectRepository {

    private final SessionFactory sessionFactory;

    public ProjectRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Project.class).addOrder(Order.asc("code")).list();
    }

    public Project getProject(long id) {
        return (Project) sessionFactory.getCurrentSession().get(Contract.class, id);
    }

    public List<Project> findProjectByCode(String code) {
        return sessionFactory.getCurrentSession().createCriteria(Project.class).add(Restrictions.eq("code", code)).list();
    }

    public Project saveOrUpdate(Project project) {
        long projectId = 0;
        if(project.getId() != null) {
            sessionFactory.getCurrentSession().update(project);
            projectId = project.getId();
        } else {
            projectId = (long) sessionFactory.getCurrentSession().save(projectId);
        }
        return  getProject(projectId);
    }

    public void deleteProject(long id) {
        sessionFactory.getCurrentSession().delete(getProject(id));
    }
}
