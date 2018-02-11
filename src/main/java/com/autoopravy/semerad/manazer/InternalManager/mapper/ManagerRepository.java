package com.autoopravy.semerad.manazer.InternalManager.mapper;


import com.autoopravy.semerad.manazer.InternalManager.model.Car;
import com.autoopravy.semerad.manazer.InternalManager.model.Customer;
import com.autoopravy.semerad.manazer.InternalManager.model.Repair;
import com.autoopravy.semerad.manazer.InternalManager.model.SparePart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Interface to mybatis. Passing parameters to mybatis.
 */

@Mapper
public interface ManagerRepository {

    List<Customer> getAllCustomers();

    List<Car> getAllCars();

    List<Repair> getAllRepairs();

    List<SparePart> getAllParts();

    List<Car> getCar();

    List<Repair> getRepair();

    List<SparePart> getPart();

    Customer getUserById(Integer id);

    List<Customer> getUserDetailById(@Param("userId") Integer id);

    void insertUser(Customer customer);

    void updateUser(Customer customer);

    void deleteUser(Integer id);


//    List<Record> searchByName(@Param("name") String name);
//
//    List<Record> searchTender(@Param("name") String name, @Param("dateFrom") Date dateCreated, @Param("dateTo") Date dueDate, @Param("volumeFrom") Double volumeFrom, @Param("volumeTo") Double volumeTo);
//
//    List<Retrieval> findLastDate();
}
