package com.example.tprevision.web;

import com.example.tprevision.service.PhoneManager;
import com.example.tprevision.service.dtos.PhoneDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PhoneGraphQLController {
    private  PhoneManager phoneManager;

    @QueryMapping
    public List<PhoneDTO> getPhoneByModel(@Argument String model) {
        return phoneManager.getPhonesByModel(model);
    }

    @QueryMapping
    public List<PhoneDTO> getPhoneByModelAndPrice(@Argument String model, @Argument double price) {
        return phoneManager.getPhonesByModelAndPrice(model, price);
    }

    @MutationMapping
    public PhoneDTO savePhone(@Argument PhoneDTO phone) {
        return phoneManager.savePhone(phone);
    }

    @MutationMapping
    public void deletePhone(@Argument int id) {
        phoneManager.deletePhone(id);
    }
}
