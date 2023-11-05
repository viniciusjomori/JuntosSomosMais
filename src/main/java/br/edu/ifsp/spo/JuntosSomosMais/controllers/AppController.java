package br.edu.ifsp.spo.JuntosSomosMais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import br.edu.ifsp.spo.JuntosSomosMais.entities.Customer;
import br.edu.ifsp.spo.JuntosSomosMais.mappers.CsvMapper;
import br.edu.ifsp.spo.JuntosSomosMais.mappers.JsonMapper;
import br.edu.ifsp.spo.JuntosSomosMais.services.CustomerService;
import br.edu.ifsp.spo.JuntosSomosMais.utils.FileUtil;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class AppController {

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private CsvMapper csvMapper;

    @Autowired
    private CustomerService customerService;

    @GetMapping("delete")
    public ResponseEntity<String> deleteAll() {
        customerService.deleteAll();

        return ResponseEntity.ok("Banco de dados deletado");
    }
    
    @GetMapping("save/json")
    public ResponseEntity<String> saveDataJson() {
        String jsonString = fileUtil.readFile("data.json");
        List<Customer> customers = jsonMapper.map(jsonString);
        customerService.saveAll(customers);
        
        return ResponseEntity.ok("Json data saved");
    }

    @GetMapping("save/csv")
    public ResponseEntity<String> saveDataCsv() {
        String csvContent = fileUtil.readFile("data.csv");
        List<Customer> customers = csvMapper.map(csvContent);
        customerService.saveAll(customers);
        
        return ResponseEntity.ok("CSV data saved");
    }

    @GetMapping("customers")
    public ResponseEntity<Page<Customer>> findAll(
        @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(customerService.findAll(pageable));
    }

}
