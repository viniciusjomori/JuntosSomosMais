package br.edu.ifsp.spo.JuntosSomosMais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
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

@Service
public class JsonMapper {

    @Autowired
    private CustomerService customerService;
    
    public List<Customer> map(String jsonContent) {
        JSONArray jsonArray = new JSONArray(jsonContent);

        List<Customer> customers = new ArrayList<>();

        jsonArray.forEach(index -> {
            JSONObject customerJsonObject = (JSONObject) index;
            JSONObject locationJsonObject = customerJsonObject.getJSONObject("location");
            JSONObject coordinatesJsonObject = locationJsonObject.getJSONObject("coordinates");
            JSONObject timezoneJsonObject = locationJsonObject.getJSONObject("timezone");
            JSONObject nameJsonObject = customerJsonObject.getJSONObject("name");
            JSONObject pictureJsonObject = customerJsonObject.getJSONObject("picture");
            JSONObject dobJsonObject = customerJsonObject.getJSONObject("dob");
            JSONObject registredJsonObject = customerJsonObject.getJSONObject("registered");

            Coordinate coordinate = Coordinate.builder()
                .latitude(Float.parseFloat(
                    coordinatesJsonObject.getString("latitude")
                ))
                .longitude(Float.parseFloat(
                    coordinatesJsonObject.getString("longitude"))
                )
                .build();

            Timezone timezone = Timezone.builder()
                .offset(timezoneJsonObject.getString("offset"))
                .description(timezoneJsonObject.getString("description"))
                .build();

            Location location = Location.builder()
                .region(RegionEnum.defineRegionByState(
                    StateEnum.stringToStateEnum(
                        locationJsonObject.getString("state")
                    )
                ))
                .street(locationJsonObject.getString("street"))
                .city(locationJsonObject.getString("city"))
                .state(StateEnum.stringToStateEnum(
                    locationJsonObject.getString("state")
                ))
                .postcode(locationJsonObject.getInt("postcode"))
                .coordinate(coordinate)
                .timezone(timezone)
                .build();

            Name name = Name.builder()
                .title(nameJsonObject.getString("title"))
                .first(nameJsonObject.getString("first"))
                .last(nameJsonObject.getString("last"))
                .build();

            Set<MobileNumber> mobileNumbers = Collections.singleton(
                MobileNumber.builder()
                    .number(customerJsonObject.getString("cell"))
                    .build()
            );

            Set<TelephoneNumber> telephoneNumbers = Collections.singleton(
                TelephoneNumber.builder()
                    .number(customerJsonObject.getString("phone"))
                    .build()
            );

            Picture picture = Picture.builder()
                .large(pictureJsonObject.getString("large"))
                .medium(pictureJsonObject.getString("medium"))
                .thumbnail(pictureJsonObject.getString("thumbnail"))
                .build();

            Customer customer = Customer.builder()
                .type(customerService.defineCustomerTypeEnum(
                    coordinate
                ))
                .gender(GenderEnum.wordToEnum(
                    customerJsonObject.getString("gender")
                ))
                .email(customerJsonObject.getString("email"))
                .birthday(LocalDate.parse(
                    dobJsonObject.getString("date").substring(0, 10))
                )
                .registered(LocalDate.parse(
                    registredJsonObject.getString("date").substring(0, 10))
                )
                .name(name)
                .location(location)
                .telephoneNumbers(telephoneNumbers)
                .mobileNumbers(mobileNumbers)
                .picture(picture)
                .nacionality("BR")
                .build();

            customers.add(customer);
        });

        return customers;

    }

}
