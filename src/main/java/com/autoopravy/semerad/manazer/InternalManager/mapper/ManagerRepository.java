package com.autoopravy.semerad.manazer.InternalManager.mapper;


import com.autoopravy.semerad.manazer.InternalManager.model.Car;
import com.autoopravy.semerad.manazer.InternalManager.model.Customer;
import com.autoopravy.semerad.manazer.InternalManager.model.Repair;
import com.autoopravy.semerad.manazer.InternalManager.model.SparePart;
import com.wordnik.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
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

    //------------------------------------------------------------------------------------------------------------------

    Customer getUserById(Integer id);

    List<Customer> getUserDetailById(@Param("userId") Integer id);

    void insertUser(Customer customer);

    void updateUser(Customer customer);

    void deleteUser(Integer id);

    //------------------------------------------------------------------------------------------------------------------

//    @Select(value = "select * from cars c  where 1=1 and c.car_id=#{carId}")
//    @ResultMap("carResultMap")
    Car getCarById(@Param("carId") Integer id);

    List<Car> getCarDetailById(@Param("carId") Integer id);

    void insertCar(Car car);

    void updateCar(Car car);

    void deleteCar(Integer id);

    //------------------------------------------------------------------------------------------------------------------

//    List<Record> searchByName(@Param("name") String name);
//
//    List<Record> searchTender(@Param("name") String name, @Param("dateFrom") Date dateCreated, @Param("dateTo") Date dueDate, @Param("volumeFrom") Double volumeFrom, @Param("volumeTo") Double volumeTo);
//
//    List<Retrieval> findLastDate();
}
