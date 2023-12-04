package com.example.demo.repository;

import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
//    @Query("SELECT ProductModelID, Name
//            FROM SalesLT.Product
//            WHERE (ProductCategoryID=6 OR ProductModelID=6) AND  Weight IN (SELECT MAX(Weight)
//            FROM SalesLT.Product GROUP BY ProductModelID)
//            Order By ProductModelID")
//    List<Message> getChats(User user);

}
