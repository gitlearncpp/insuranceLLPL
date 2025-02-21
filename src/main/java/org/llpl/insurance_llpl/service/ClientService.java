package org.llpl.insurance_llpl.service;

import org.llpl.insurance_llpl.dto.ClientDTO;
import org.llpl.insurance_llpl.mapper.ClientMapper;
import org.llpl.insurance_llpl.model.Client;
import org.llpl.insurance_llpl.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        if (clientRepository.existsByPesel(clientDTO.getPesel())) {
            throw new RuntimeException("Client with this PESEL already exists");
        }

        Client client = clientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDTO(savedClient);
    }

    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        return clientMapper.toDTO(client);
    }
}