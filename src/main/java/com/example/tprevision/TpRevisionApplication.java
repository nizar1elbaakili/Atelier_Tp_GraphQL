package com.example.tprevision;

import com.example.tprevision.dao.entities.Phone;
import com.example.tprevision.dao.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class TpRevisionApplication implements CommandLineRunner{
    private final PhoneRepository phnRepo;

    public static void main(String[] args) {
        SpringApplication.run(TpRevisionApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        phnRepo.save(Phone.builder()
                        .model("jssjsjs")
                        .color("Red")
                        .IMEI("alkslakalsklas")
                        .price(11101010)
                .build());
    }
}
