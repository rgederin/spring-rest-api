package com.gederin.bootstrap;

import com.gederin.model.CarBrand;
import com.gederin.model.CarModel;
import com.gederin.repository.CarBrandRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CarBrandRepository carBrandRepository;

    @Override
    public void run(String... strings) throws Exception {
        bootstrap();
    }

    private void bootstrap() {
        CarBrand honda = new CarBrand();

        honda.setName("Honda");
        honda.setCountry("Japan");
        honda.setDescription("Honda has been the world's largest motorcycle manufacturer since 1959");

        CarModel hondaAccord = new CarModel();

        hondaAccord.setName("Honda Accord");
        hondaAccord.setType("Sedan");

        honda.addCarModel(hondaAccord);

        carBrandRepository.save(honda);
    }
}
