package org.llpl.insurance_llpl.controller;

import org.llpl.insurance_llpl.dto.ClientDTO;
import org.llpl.insurance_llpl.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.createClient(clientDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }
}