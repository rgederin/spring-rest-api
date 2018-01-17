package com.gederin.api.v1.bootstrap;

import com.gederin.api.v1.model.CarBrand;
import com.gederin.api.v1.model.CarModel;
import com.gederin.api.v1.repository.CarBrandRepository;

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

        CarModel hondaCivic = new CarModel();

        hondaCivic.setName("Honda Civic");
        hondaCivic.setType("Sedan");

        honda.addCarModel(hondaCivic);

        carBrandRepository.save(honda);

        CarBrand audi = new CarBrand();

        audi.setName("Audi");
        audi.setCountry("Germany");
        audi.setDescription("Audi is is a German automobile manufacturer that designs, engineers, produces, markets and distributes luxury vehicles.");

        CarModel audiTT = new CarModel();

        audiTT.setName("Audi TT");
        audiTT.setType("Sportcar");

        audi.addCarModel(audiTT);

        carBrandRepository.save(audi);
    }
}
