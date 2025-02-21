package org.llpl.insurance_llpl.mapper;

import org.llpl.insurance_llpl.dto.ClientDTO;
import org.llpl.insurance_llpl.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        if (client == null) {
            return null;
        }
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

    public Client toEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setPesel(dto.getPesel());
        client.setBirthDate(dto.getBirthDate());
        client.setPostalCode(dto.getPostalCode());
        client.setEmail(dto.getEmail());
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setStreet(dto.getStreet());
        client.setCity(dto.getCity());
        client.setCountry(dto.getCountry());
        client.setState(dto.getState());
        client.setHouseNumber(dto.getHouseNumber());
        client.setApartmentNumber(dto.getApartmentNumber());
        client.setGender(dto.getGender());
        client.setDeclaredGender(dto.getDeclaredGender());
        client.setMarketingConsent(dto.isMarketingConsent());
        client.setEmailConsent(dto.isEmailConsent());
        return client;
    }
}