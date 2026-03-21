package com.example.JPA.Task;
public interface DAO {
    void save(Task task);
    Task findById(Integer id);

    void deletedById(Integer id);
    void patchDeleted(int arr[]);
    Task updateById(Integer id, String task);

}
