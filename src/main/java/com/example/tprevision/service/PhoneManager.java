package com.example.tprevision.service;

import com.example.tprevision.service.dtos.PhoneDTO;

import java.util.List;

public interface PhoneManager {
    PhoneDTO savePhone(PhoneDTO phoneDTO);
    void deletePhone(int id);
    List<PhoneDTO> getPhonesByModel(String model);
    List<PhoneDTO> getPhonesByModelAndPrice(String model, double price);
}
