package com.example.tprevision.service;

import com.example.tprevision.dao.entities.Phone;
import com.example.tprevision.dao.repository.PhoneRepository;
import com.example.tprevision.service.dtos.PhoneDTO;
import com.example.tprevision.service.mappers.PhoneMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneManagerAction implements PhoneManager{
    private  PhoneRepository phoneRepository;
    private PhoneMapper phoneMapper;

    @Override
    public PhoneDTO savePhone(PhoneDTO phoneDTO) {
        if (phoneRepository.existsByIMEI(phoneDTO.getIMEI())) {
            throw new IllegalArgumentException("IMEI already exists");
        }
        Phone phone = phoneMapper.fromPhoneDtotoPhone(phoneDTO);
        return phoneMapper.fromPhonetoPhoneDto(phoneRepository.save(phone));
    }

    @Override
    public void deletePhone(int  id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public List<PhoneDTO> getPhonesByModel(String model) {
        return phoneRepository.findByModel(model)
                .stream()
                .map(phoneMapper::fromPhonetoPhoneDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PhoneDTO> getPhonesByModelAndPrice(String model, double price) {
        return phoneRepository.findByModelAndPrice(model, price)
                .stream()
                .map(phoneMapper::fromPhonetoPhoneDto)
                .collect(Collectors.toList());
    }
}
