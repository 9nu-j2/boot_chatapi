package com.example.demo.repository;

import com.example.demo.dto.SalesGroupByInter;
import com.example.demo.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
    @Query("select\n" +
            "    trim(category) as category,\n" +
            "    count(category) as cnt,\n" +
            "    round(avg(price),2) as price,\n" +
            "    round(avg(amount),2) as amount\n" +
            "from\n" +
            "    Sales\n" +
            "group by\n" +
            "    category\n" +
            "order by\n" +
            "    avg(price) desc")
    List<SalesGroupByInter> findGroupbySalesData();
}
