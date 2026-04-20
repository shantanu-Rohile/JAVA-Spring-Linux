package com.example.revesion.DAO;

import com.example.revesion.ENTITY.Report;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class DaoReportImpl implements DaoReport{

    @Autowired
    private EntityManager em;
    private JsonMapper jsonMapper;
    private DaoReport dao;
    public DaoReportImpl(EntityManager em, DaoReport dao){
        this.em=em;
        this.dao=dao;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public String create(Report report) {
        em.persist(report);
        return "Report Added Successfully";
    }

    @Override
    public Report readReports(int id) {
        Report rep=em.find(Report.class,id);
        return rep;
    }

    @Override
    public List<Report> readAllReport() {
        List<Report> reports=em.createNativeQuery("SELECT * FROM report", Report.class).getResultList();
        return reports;
    }

    @Override
    public Report update(int id, Map<String, Objects> patchBody){
        Report temp=em.find(Report.class,id);
        if(temp==null){
            throw new RuntimeException("Report no found");
        }
        if(patchBody.containsKey("id")){
            throw new RuntimeException("We can not cange the id");
        }

        Report repo=jsonMapper.updateValue(temp,patchBody);
        return dao.save(repo);
    }

    @Override
    public Report save(Report report){
        Report report1=em.merge(report);
        return report1;
    }

    @Override
    public String delete(int id) {
        Report report=em.find(Report.class,id);
        em.remove(report);
        return "Report is removed successfully";
    }
}
