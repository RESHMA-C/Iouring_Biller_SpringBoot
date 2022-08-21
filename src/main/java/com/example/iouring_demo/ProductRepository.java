package com.example.iouring_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import com.example.iouring_demo.ProductRecord;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<ProductRecord,Long>
{
    List<ProductRecord> findByProductCodeOrProductName(String productCode,String ProductName);
}

