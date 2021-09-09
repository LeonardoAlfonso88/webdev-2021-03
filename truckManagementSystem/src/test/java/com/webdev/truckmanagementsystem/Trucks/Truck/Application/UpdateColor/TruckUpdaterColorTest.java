package com.webdev.truckmanagementsystem.Trucks.Truck.Application.UpdateColor;

import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.UUIDNotValid;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.ColorFormatNotValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotColorCentralValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.TruckNotFound;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckColorValidator;
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
public class TruckUpdaterColorTest {

    Truck truck;
    TruckRepository repository;
    TruckColorValidator colorValidator;

    @BeforeEach
    void setup() {
        //Data Falsa - Objeto Referencia
        this.truck = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"),
                new TruckBrand("Ford"),
                new TruckModelYear(2000),
                new TruckPlate("FAA123"),
                new TruckColor("#454545"),
                new TruckInsuranceValue(500000d),
                new TruckMechanicalRevisionDate("05-05-2018"),
                new TruckTotalDistance(0d),
                new OwnerId("6543fbcf-fe01-4c25-a851-a8c46ac38f27"), null, null);

        //Preparar el mock - implementación falsa
        this.repository = mock(TruckRepository.class);
        this.colorValidator = mock(TruckColorValidator.class);

        //Configuración del mock
        Mockito.when(repository.find(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"))).
                thenReturn(Optional.of(truck));
        Mockito.when(colorValidator.validateColor(new TruckColor("#AFF444"))).thenReturn(true);
    }

    @Test
    void should_update_color_truck() {
        //Caso de uso
        TruckUpdaterColor updater = new TruckUpdaterColor(repository, colorValidator);

        //Data Falsa - Objeto Referencia Destino
        Truck truckEdited = new Truck(new TruckId("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa"),
                new TruckBrand("Ford"),
                new TruckModelYear(2000),
                new TruckPlate("FAA123"),
                new TruckColor("#AFF444"),
                new TruckInsuranceValue(500000d),
                new TruckMechanicalRevisionDate("05-05-2018"),
                new TruckTotalDistance(0d),
                new OwnerId("6543fbcf-fe01-4c25-a851-a8c46ac38f27"), null, null);

        //Ejecutar el caso de uso
        updater.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa", "#AFF444");

        //Verificar
        verify(repository, atLeastOnce()).save(truckEdited);
    }

    @Test
    void not_should_udpate_color_truck_by_not_found_truck() {
        //Caso de uso
        TruckUpdaterColor updater = new TruckUpdaterColor(repository, colorValidator);

        //Verificación
        Assertions.assertThrows(TruckNotFound.class, () -> {
            updater.execute("c688fc91-892a-4e89-9950-eec3ed6f634f", "#AFF444");
        });
    }

    @Test
    void not_should_udpate_color_truck_by_color_format_invalid() {
        //Caso de uso
        TruckUpdaterColor updater = new TruckUpdaterColor(repository, colorValidator);

        //Verificación
        Assertions.assertThrows(ColorFormatNotValid.class, () -> {
            updater.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa", "Red");
        });
    }

    @Test
    void not_should_udpate_color_truck_by_color_central_not_valid() {
        //Caso de uso
        TruckUpdaterColor updater = new TruckUpdaterColor(repository, colorValidator);

        //Verificación
        Assertions.assertThrows(NotColorCentralValid.class, () -> {
            updater.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa", "#BCC123");
        });
    }

    @Test
    void not_should_udpate_color_truck_by_truck_id_not_valid() {
        //Caso de uso
        TruckUpdaterColor updater = new TruckUpdaterColor(repository, colorValidator);

        //Verificación
        Assertions.assertThrows(UUIDNotValid.class, () -> {
            updater.execute("c688fc91-892a-4e89-9950", "#AFF444");
        });
    }
}