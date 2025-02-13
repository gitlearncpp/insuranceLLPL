package org.llpl.insurance_llpl.service;

import org.llpl.insurance_llpl.dto.ClientDTO;
import org.llpl.insurance_llpl.model.Client;
import org.llpl.insurance_llpl.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        if (clientRepository.existsByPesel(clientDTO.getPesel())) {
            throw new RuntimeException("Client with this PESEL already exists");
        }

        Client client = new Client();
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setPesel(clientDTO.getPesel());
        client.setPostalCode(clientDTO.getPostalCode());
        client.setEmail(clientDTO.getEmail());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setAddress(clientDTO.getAddress());
        client.setMarketingConsent(clientDTO.isMarketingConsent());

        Client savedClient = clientRepository.save(client);
        return mapToDTO(savedClient);
    }

    private ClientDTO mapToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPesel(client.getPesel());
        dto.setPostalCode(client.getPostalCode());
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setAddress(client.getAddress());
        dto.setMarketingConsent(client.isMarketingConsent());
        return dto;
    }
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        return mapToDTO(client);
    }

}