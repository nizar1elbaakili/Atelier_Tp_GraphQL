package com.example.tprevision.dao.repository;

import com.example.tprevision.dao.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {
    boolean existsByIMEI(String IMEI);

    List<Phone> findByModel(String model);

    List<Phone> findByModelAndPrice(String model, double price);
}
