package br.edu.ifsp.spo.JuntosSomosMais.utils;

import org.springframework.stereotype.Service;

@Service
public class PhoneUtil {
    
    public String toE164(String phoneNumber) {
        String numericPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        String internationalPhoneNumber = "+55" + numericPhoneNumber;
        return internationalPhoneNumber;
    }
}
