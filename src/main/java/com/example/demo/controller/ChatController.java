package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/chat")
@Slf4j
@RestController
public class ChatController {

    //GET
    @GetMapping("/enter")
    @Tag(name="세일즈 데이터 집계", description = "세일즈 데이터 집계 조회")
    @Operation(summary="카테고리 개수, 평균 가격/개수 조회", description = "카테고리 개수, 평균 가격/개수 조회")
    public void Sales() {

    }
}
