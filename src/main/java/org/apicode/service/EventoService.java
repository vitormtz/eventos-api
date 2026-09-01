/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.service;

import java.util.ArrayList;
import org.apicode.model.Evento;
import org.apicode.model.Presenca;
import org.apicode.model.UsuarioRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/eventos")
public class EventoService {

    private RestTemplate restTemplate = new RestTemplate();

    public EventoService() {
    }

    public EventoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Evento>> listarEventos() {
        String url = "http://localhost:8080/eventos";

        ResponseEntity<ArrayList<Evento>> responseEntity = restTemplate.exchange(
                url,
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<Evento>>() {
        }
        );

        if (responseEntity.getBody() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(responseEntity.getBody());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<UsuarioRequest>> obterEventoPorId(@PathVariable int id) {
        String url = "http://localhost:8080/eventos/{id}";

        ResponseEntity<ArrayList<UsuarioRequest>> responseEntity = restTemplate.exchange(
                url,
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<UsuarioRequest>>() {
        },
                id
        );

        if (responseEntity.getBody() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(responseEntity.getBody());
        }
    }

    @PostMapping("/presencas")
    public ResponseEntity<String> registrarPresenca(@RequestBody Presenca presencaRequest) {

        String url = "http://localhost:8080/eventos/presencas";

        if (restTemplate.postForObject(url, presencaRequest, Presenca.class) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        }
    }
}
