package org.llpl.insurance_llpl.service;

import org.llpl.insurance_llpl.dto.ClientDTO;
import org.llpl.insurance_llpl.mapper.ClientMapper;
import org.llpl.insurance_llpl.model.Client;
import org.llpl.insurance_llpl.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    // Tworzenie klienta
    public ClientDTO createClient(ClientDTO clientDTO) {
        if (clientRepository.existsByPesel(clientDTO.getPesel())) {
            throw new RuntimeException("Client with this PESEL already exists.");
        }

        // Mapowanie DTO na encję za pomocą mappera
        Client client = clientMapper.toEntity(clientDTO);

        // Zapis do bazy
        Client savedClient = clientRepository.save(client);

        // Mapowanie encji na DTO przed zwróceniem odpowiedzi
        return clientMapper.toDTO(savedClient);
    }

    // Pobieranie klienta po ID
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.toDTO(client);
    }
}