package com.autoopravy.semerad.manazer.InternalManager.mapper;


import com.autoopravy.semerad.manazer.InternalManager.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Interface to mybatis. Passing parameters to mybatis.
 */

@Mapper
public interface ManagerRepository {

    List<User> getUser(@Param("userId") Long id);

//    List<Record> searchCustomer(@Param("ico") String ico, @Param("name") String name);
//
//    List<Record> searchByName(@Param("name") String name);
//
//    List<Record> searchTender(@Param("name") String name, @Param("dateFrom") Date dateCreated, @Param("dateTo") Date dueDate, @Param("volumeFrom") Double volumeFrom, @Param("volumeTo") Double volumeTo);
//
//    List<Retrieval> findLastDate();
}
