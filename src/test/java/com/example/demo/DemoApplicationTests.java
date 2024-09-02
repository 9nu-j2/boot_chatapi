package com.example.demo;

import com.example.demo.dto.SalesGroupByInter;
import com.example.demo.repository.SalesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private SalesRepository salesRepository;

	@Test
	void contextLoads() {
		List<SalesGroupByInter> res = salesRepository.findGroupbySalesData();

	}

}
