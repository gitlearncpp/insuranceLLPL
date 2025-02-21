package org.llpl.insurance_llpl.controller;

import org.llpl.insurance_llpl.dto.ClientDTO;
import org.llpl.insurance_llpl.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    // Endpoint do tworzenia klienta
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.createClient(clientDTO));
    }

    // Endpoint do pobierania klienta po ID
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }
}