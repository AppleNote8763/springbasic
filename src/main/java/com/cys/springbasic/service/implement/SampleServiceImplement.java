package com.cys.springbasic.service.implement;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cys.springbasic.dto.PostSample1RequestDto;
import com.cys.springbasic.entity.SampleTable1Entity;
import com.cys.springbasic.entity.SampleUserEntity;
import com.cys.springbasic.repository.SampleTable1Repository;
import com.cys.springbasic.repository.SampleUserRepository;
import com.cys.springbasic.service.SampleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleServiceImplement implements SampleService {

    private final SampleUserRepository sampleUserRepository;
    private final SampleTable1Repository sampleTable1Repository;

    @Override
    public ResponseEntity<String> postSample1(PostSample1RequestDto dto) {

        String sampleId = dto.getSampleId();
        Integer sampleColumn = dto.getSampleColumn();

        // SELECT (SQL : SELECT)
        // 1. repository를 이용하여 조회 (findAll, findById)
        // SampleTable1Entity existEntity = sampleTable1Repository.findById(sampleId).get();
        // 2. repository를 이용하여 조회 (existsById)
        boolean isExisted = sampleTable1Repository.existsById(sampleId);
        if (isExisted) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 존재하는 기본키 입니다.");

        // CREATE (SQL : INSERT)
        // 1. Entity 클래스의 인스턴스 생성
        SampleTable1Entity entity = new SampleTable1Entity(sampleId, sampleColumn);

        // 2. 생성한 인스턴스를 repository를 이용하여 저장
        // save() : 저장
        // - 만약에 Primary key가 동일한 레코드가 존재하지 않으면 레코드 생성
        // - 동일한 레코드가 존재하면 수정
        sampleTable1Repository.save(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body("성공");

    }

    @Override
    public ResponseEntity<String> deleteSample1(String sampleId) {

        // DELETE (SQL : DELETE)
        // 1. repository를 이용하여 ID(PK)에 해당하는 레코드 삭제
        //    - 해당하는 레코드가 존재하지 않아도 에러가 발생하지 않음

        sampleTable1Repository.deleteById(sampleId);
        // 2. repository를 이용하여 Entit에 해당하는 레코드 삭제
        //    - 해당하는 레코드가 존재하지 않을때 수행 불가능
        
        SampleTable1Entity entity = sampleTable1Repository.findById(sampleId).get();
        sampleTable1Repository.delete(entity);

        return ResponseEntity.status(HttpStatus.OK).body("성공");

    }

    @Override
    public ResponseEntity<String> queryMethod() {

        List<SampleUserEntity> sampleUserEntities = sampleUserRepository.getNativeSql("홍길동", "부산광역시");

        return ResponseEntity.status(HttpStatus.OK).body(sampleUserEntities.toString());

    }

}
