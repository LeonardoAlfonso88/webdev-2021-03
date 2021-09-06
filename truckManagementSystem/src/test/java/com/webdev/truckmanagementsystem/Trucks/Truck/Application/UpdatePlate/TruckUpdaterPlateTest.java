package com.webdev.truckmanagementsystem.Trucks.Truck.Application.UpdatePlate;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.PlateFormatNotValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.PlateLengthNotValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.TruckNotFound;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TruckUpdaterPlateTest {

    Truck truck;
    TruckRepository repository;

    @BeforeEach
    void setup() {
        //Data Falsa - Objeto Referencia
        this.truck = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"),
                new TruckBrand("Ford"),
                new TruckModelYear(2000),
                new TruckPlate("FAA123"),
                new TruckColor("#454545"),
                new TruckInsuranceValue(500000d),
                new TruckMechanicalRevisionDate("05-05-2018"));

        //Preparar el mock - implementación falsa
        this.repository = mock(TruckRepository.class);

        //Configurar el mock
        Mockito.when(repository.find(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"))).thenReturn(Optional.of(truck));
    }

    @Test
    void should_udpate_plate_truck() {
        //Caso de uso
        TruckUpdaterPlate updater = new TruckUpdaterPlate(repository);

        //Data Falsa - Objeto Referencia Destino
        Truck truckEdited = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"),
                new TruckBrand("Ford"),
                new TruckModelYear(2000),
                new TruckPlate("ABC123"),
                new TruckColor("#454545"),
                new TruckInsuranceValue(500000d),
                new TruckMechanicalRevisionDate("05-05-2018"));

        //Ejecutar el caso de uso
        updater.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa", "ABC123");

        //Ejecutar
        verify(repository, atLeastOnce()).save(truckEdited);
    }

    @Test
    void not_should_udpate_plate_truck_by_not_found_truck() {
        //Caso de uso
        TruckUpdaterPlate updater = new TruckUpdaterPlate(repository);

        //Verificación
        Assertions.assertThrows(TruckNotFound.class, () -> {
            updater.execute("c688fc91-892a-4e89-9950-eec3ed6f634f", "ABC123");
        });
    }

    @Test
    void should_not_update_plate_truck_by_plate_format_not_valid() {
        //Caso de uso
        TruckUpdaterPlate updater = new TruckUpdaterPlate(repository);

        //Verificación
        Assertions.assertThrows(PlateFormatNotValid.class, () -> {
            updater.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa", "ABDC1234");
        });
    }

    @Test
    void should_not_update_plate_truck_by_plate_length_not_valid() {
        //Caso de uso
        TruckUpdaterPlate updater = new TruckUpdaterPlate(repository);

        //Verificación
        Assertions.assertThrows(PlateLengthNotValid.class, () -> {
            updater.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa", "ABD123A1");
        });
    }
}