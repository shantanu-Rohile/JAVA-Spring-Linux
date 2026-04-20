package com.example.revesion.DAO;

import com.example.revesion.ENTITY.Confession;
import com.example.revesion.ENTITY.Report;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface DaoReport {
    String create(Report report);
    Report readReports(int id);
    List<Report> readAllReport();
    Report update(int id, Map<String, Objects> patchBody);
    String delete(int id);
    Report save(Report report);
}
