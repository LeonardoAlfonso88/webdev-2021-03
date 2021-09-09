package com.webdev.truckmanagementsystem.Trucks.Truck.Application.Create;

import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.UUIDNotValid;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.*;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckColorValidator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TruckCreatorTest {

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
                new OwnerId("6543fbcf-fe01-4c25-a851-a8c46ac38f27"));

        //Preparar el mock - implementación falsa
        this.repository = mock(TruckRepository.class);
        this.colorValidator = mock(TruckColorValidator.class);

        //Configuración del mock
        Mockito.when(colorValidator.validateColor(new TruckColor("#454545"))).thenReturn(true);
    }

    @Test
    void should_create_truck() {

        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        //Ejecutar el caso de uso
        creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                "Ford",
                2000,
                "FAA123",
                "#454545",
                500000d,
                "05-05-2018",
                "6543fbcf-fe01-4c25-a851-a8c46ac38f27");

        //Verificar
        verify(repository, atLeastOnce()).save(truck);
    }

    @Test
    void should_not_create_truck_by_not_value_uuid() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(UUIDNotValid.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5",
                    "Ford",
                    2000,
                    "FAA123",
                    "#454545",
                    500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_empty_brand() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(NotEmptyBrand.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "",
                    2000,
                    "FAA123",
                    "#454545",
                    500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_model_year_length_not_valid() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(ModelYearLengthNotValid.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    900,
                    "FAA123",
                    "#454545",
                    500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_model_year_not_allowed() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(ModelYearValueNotAllowed.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    1988,
                    "FAA123",
                    "#454545",
                    500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_plate_format_not_valid() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(PlateFormatNotValid.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    2000,
                    "AAAA5555",
                    "#454545",
                    500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_plate_length_not_valid() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(PlateLengthNotValid.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    2000,
                    "ABC12",
                    "#454545",
                    500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_color_format_invalid() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(ColorFormatNotValid.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    2000,
                    "FAA123",
                    "Red",
                    500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_not_positive_insurance_value() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(NotPositiveInsuranceValue.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    2000,
                    "FAA123",
                    "#454545",
                    -500000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_not_max_value_allowed() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(NotValidMaxInsuranceValue.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    2000,
                    "FAA123",
                    "#454545",
                    2000000d,
                    "05-05-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_not_mechanical_date_valid_format() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(NotValidMechanicalDateFormat.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    2000,
                    "FAA123",
                    "#454545",
                    500000d,
                    "05-25-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }

    @Test
    void should_not_create_truck_by_color_not_central_valid() {
        //Caso de uso
        TruckCreator creator = new TruckCreator(repository, colorValidator);

        Assertions.assertThrows(NotColorCentralValid.class, () -> {
            creator.execute("9007ee55-d8eb-4d0c-b1d5-f66a61ab4aaa",
                    "Ford",
                    2000,
                    "FAA123",
                    "#45454A",
                    500000d,
                    "05-25-2018",
                    "6543fbcf-fe01-4c25-a851-a8c46ac38f27");
        });
    }
}