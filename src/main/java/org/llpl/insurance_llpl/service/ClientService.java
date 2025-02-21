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
        client.setBirthDate(clientDTO.getBirthDate());
        client.setPostalCode(clientDTO.getPostalCode());
        client.setEmail(clientDTO.getEmail());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setStreet(clientDTO.getStreet());
        client.setCity(clientDTO.getCity());
        client.setCountry(clientDTO.getCountry());
        client.setState(clientDTO.getState());
        client.setHouseNumber(clientDTO.getHouseNumber());
        client.setApartmentNumber(clientDTO.getApartmentNumber());
        client.setGender(clientDTO.getGender());
        client.setDeclaredGender(clientDTO.getDeclaredGender());
        client.setMarketingConsent(clientDTO.isMarketingConsent());
        client.setEmailConsent(clientDTO.isEmailConsent());

        Client savedClient = clientRepository.save(client);
        return mapToDTO(savedClient);
    }

    private ClientDTO mapToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPesel(client.getPesel());
        dto.setBirthDate(client.getBirthDate());
        dto.setPostalCode(client.getPostalCode());
        dto.setCity(client.getCity());
        dto.setCountry(client.getCountry());
        dto.setState(client.getState());
        dto.setStreet(client.getStreet());
        dto.setHouseNumber(client.getHouseNumber());
        dto.setApartmentNumber(client.getApartmentNumber());
        dto.setGender(client.getGender());
        dto.setDeclaredGender(client.getDeclaredGender());
        dto.setEmailConsent(client.isEmailConsent());
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setMarketingConsent(client.isMarketingConsent());
        return dto;
    }
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        return mapToDTO(client);
    }

}