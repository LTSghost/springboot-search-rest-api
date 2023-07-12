package net.java.test.springbootsearchrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.test.springbootsearchrestapi.entity.BaseParam;

public interface BaseParamRepository extends JpaRepository<BaseParam, String>{
    List<BaseParam> findByTitle(String title);
}
