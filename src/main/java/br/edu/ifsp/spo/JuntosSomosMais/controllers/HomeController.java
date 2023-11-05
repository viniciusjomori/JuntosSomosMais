package br.edu.ifsp.spo.JuntosSomosMais.controllers;

import br.edu.ifsp.spo.JuntosSomosMais.entities.Customer;
import br.edu.ifsp.spo.JuntosSomosMais.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/home")
    public String home(
            Model model,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable
    ) {
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        return "home";
    }

}
