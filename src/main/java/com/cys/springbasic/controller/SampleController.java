package com.cys.springbasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cys.springbasic.dto.PostSample1RequestDto;
import com.cys.springbasic.service.SampleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    
    @PostMapping("")
    public ResponseEntity<String> postSample1 (
        @RequestBody @Valid PostSample1RequestDto requestBody
    ) {
        ResponseEntity<String> response = sampleService.postSample1(requestBody);
        return response;
    }

}
