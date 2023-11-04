package br.edu.ifsp.spo.JuntosSomosMais.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileUtil {
    
    public String readFile (String caminho) {
            try {
                return new String(Files.readAllBytes(Paths.get(caminho)), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException("Read error");
            }
    }
}
