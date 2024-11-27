package com.example.tprevision.service.mappers;

import com.example.tprevision.dao.entities.Phone;
import com.example.tprevision.service.dtos.PhoneDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PhoneDTO fromPhonetoPhoneDto(Phone phone) {
        return modelMapper.map(phone, PhoneDTO.class);
    }

    public Phone fromPhoneDtotoPhone(PhoneDTO phoneDTO) {
        return modelMapper.map(phoneDTO, Phone.class);
    }


}
