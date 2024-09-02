package com.example.demo.service;

import com.example.demo.dto.SalesGroupBy;
import com.example.demo.dto.SalesGroupByInter;
import com.example.demo.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public List<SalesGroupBy> getSalesGroupByDate() {
        List<SalesGroupByInter> res = salesRepository.findGroupbySalesData();
        List<SalesGroupBy> results = new ArrayList<>();
        for(SalesGroupByInter r : res) {
            results.add(SalesGroupBy.builder().category(null).cnt(0).price(0).amount(0).build());
        }
        return results;
    }
}
