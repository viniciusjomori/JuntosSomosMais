package br.edu.ifsp.spo.JuntosSomosMais.mappers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.spo.JuntosSomosMais.entities.Coordinate;
import br.edu.ifsp.spo.JuntosSomosMais.entities.Customer;
import br.edu.ifsp.spo.JuntosSomosMais.entities.Location;
import br.edu.ifsp.spo.JuntosSomosMais.entities.MobileNumber;
import br.edu.ifsp.spo.JuntosSomosMais.entities.Name;
import br.edu.ifsp.spo.JuntosSomosMais.entities.Picture;
import br.edu.ifsp.spo.JuntosSomosMais.entities.TelephoneNumber;
import br.edu.ifsp.spo.JuntosSomosMais.entities.Timezone;
import br.edu.ifsp.spo.JuntosSomosMais.enums.GenderEnum;
import br.edu.ifsp.spo.JuntosSomosMais.enums.RegionEnum;
import br.edu.ifsp.spo.JuntosSomosMais.enums.StateEnum;
import br.edu.ifsp.spo.JuntosSomosMais.services.CustomerService;
import br.edu.ifsp.spo.JuntosSomosMais.utils.PhoneUtil;

@Service
public class CsvMapper {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PhoneUtil phoneUtil;
    
    public List<Customer> map(String csvContent) {
        List<Customer> customers = new ArrayList<>();

        try {
            CSVParser parser = CSVParser.parse(csvContent.substring(1), CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
            );

            for(CSVRecord record : parser) {

                Coordinate coordinate = Coordinate.builder()
                    .latitude(Float.parseFloat(record.get("location__coordinates__latitude")))
                    .longitude(Float.parseFloat(record.get("location__coordinates__longitude")))
                    .build();

                Timezone timezone = Timezone.builder()
                    .offset(record.get("location__timezone__offset"))
                    .description(record.get("location__timezone__description"))
                    .build();

                Location location = Location.builder()
                    .region(RegionEnum.defineRegionByState(StateEnum.stringToStateEnum(record.get("location__state"))))
                    .street(record.get("location__street"))
                    .city(record.get("location__city"))
                    .state(StateEnum.stringToStateEnum(record.get("location__state")))
                    .postcode(Integer.parseInt(record.get("location__postcode")))
                    .coordinate(coordinate)
                    .timezone(timezone)
                    .build();

                Name name = Name.builder()
                    .title(record.get("name__title"))
                    .first(record.get("name__first"))
                    .last(record.get("name__last"))
                    .build();

                Picture picture = Picture.builder()
                    .large(record.get("picture__large"))
                    .medium(record.get("picture__medium"))
                    .thumbnail(record.get("picture__thumbnail"))
                    .build();

                Customer customer = Customer.builder()
                    .type(customerService.defineCustomerTypeEnum(coordinate))
                    .gender(GenderEnum.wordToEnum(record.get("gender")))
                    .email(record.get("email"))
                    .birthday(LocalDate.parse(record.get("dob__date").substring(0, 10)))
                    .registered(LocalDate.parse(record.get("registered__date").substring(0, 10)))
                    .name(name)
                    .location(location)
                    .picture(picture)
                    .nacionality("BR")
                    .build();

                Set<MobileNumber> mobileNumbers = Collections.singleton(
                    MobileNumber.builder()
                        .number(phoneUtil.toE164(record.get("cell")))
                        .customer(customer)
                        .build()
                );

                Set<TelephoneNumber> telephoneNumbers = Collections.singleton(
                    TelephoneNumber.builder()
                        .number(phoneUtil.toE164(record.get("phone")))
                        .customer(customer)
                        .build()
                );

                customer.setMobileNumbers(mobileNumbers);
                customer.setTelephoneNumbers(telephoneNumbers);

                customers.add(customer);
            }
            
            return customers;

        } catch(IOException e) {
            return null;
        }
        
    }
}
