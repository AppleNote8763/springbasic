package com.cys.springbasic.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cys.springbasic.entity.SampleUserEntity;

@Repository
public interface SampleUserRepository
extends JpaRepository<SampleUserEntity, String> {

    // Query Method:
    // - Repository의 메서드 선언시에 지정된 패턴에 따라 메서드명을 작성하면 JPA가 SQL을 만들어주는 방법
    // - findBy : 필드명을 기준으로 모든 컬럼을 조회할 때 사용, findBy 뒤에 필드명을 붙여서 작성, 필드명의 첫글자는 대문자 이어야함
    List<SampleUserEntity> findByName(String name);
    SampleUserEntity findByTelNumber(String telNumber);

    // - And/Or : and 연산 혹은 or 연산에 사용됨, 필드와 필드 사이에 사용
    //   And/Or의 우선순위 주의
    List<SampleUserEntity> findByNameAndAddress(String name, String address);

    // - Like, NotLike, StartingWith, EndingWith, Containing: Like 연산에 사용, 필드 뒤에 사용
    List<SampleUserEntity> findByAddressContaining(String address);

    // - OrderBy: 정렬을 사용할 필드를 지정하여 Desc, Asc 지정
    List<SampleUserEntity> findByNameOrderByTelNumberDesc(String name);

    // - existsBy: 조건에 해당하는 레코드가 존재하는지 여부 확인 시 사용
    boolean existsByName(String name);

    // - countBy: 조건에 해당하는 레코드의 개수 확인 시 사용
    int countByName(String name);

    // @Query:
    // - 쿼리 메서드의 한계를 극복하기 위해 사용하는 방식
    // - 쿼리 메서드가 사용할 수 없는 복잡한 쿼리를 직접 작성하는 방법

    // JPQL (Java Persistence Query Language)
    // - 표준 SQL과 매우 흡사하지만 ENtit 클래스와 Entity 필드로 쿼리를 작성하는 방법
    @Query(value = "SELECT u FROM user u WHERE u.name = ?1 AND u.address = ?2")
    List<SampleUserEntity> getJpql(String name, String address);

    @Query(value = "SELECT u FROM user u WHERE u.name = :name AND u.address = :address")
    List<SampleUserEntity> getJpql2(
        @Param("name") String name,
        @Param("address") String address
    );
}
