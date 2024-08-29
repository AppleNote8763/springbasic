package com.cys.springbasic.service;

import org.springframework.http.ResponseEntity;

import com.cys.springbasic.dto.PostSample1RequestDto;

public interface SampleService {

    ResponseEntity<String> postSample1 (PostSample1RequestDto dto);
    ResponseEntity<String> deleteSample1 (String sampleId);
    ResponseEntity<String> queryMethod();
    String getJwt(String name);

}
