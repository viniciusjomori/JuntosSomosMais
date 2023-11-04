package br.edu.ifsp.spo.JuntosSomosMais.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsp.spo.JuntosSomosMais.entities.Coordinate;
import br.edu.ifsp.spo.JuntosSomosMais.entities.Customer;
import br.edu.ifsp.spo.JuntosSomosMais.enums.CustomerTypeEnum;
import br.edu.ifsp.spo.JuntosSomosMais.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void saveAll(List<Customer> customers) {
        repository.saveAll(customers);
    }

    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public CustomerTypeEnum defineCustomerTypeEnum(Coordinate coordinate) {

        float lat = coordinate.getLatitude();
        float lon = coordinate.getLongitude();

        if(lon > -15.411580 && lat > -46.361899 && lon < -2.196998 && lat < -34.276938) {
            return CustomerTypeEnum.SPECIAL;
        } else if(lon > -23.966413 && lat > -52.997614 && lon < -19.766959 && lat < -44.428305) {
            return CustomerTypeEnum.SPECIAL;
        } else if (lon > -34.016466 && lat > -54.777426 && lon < -26.155681 && lat < -46.603598) {
            return CustomerTypeEnum.NORMAL;
        } else {
            return CustomerTypeEnum.LABORIOUS;
        }

    }

}
