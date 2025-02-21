package org.llpl.insurance_llpl.mapper;

import org.llpl.insurance_llpl.dto.ClientDTO;
import org.llpl.insurance_llpl.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientDTO dto) {
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

    public ClientDTO toDTO(Client entity) {
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPesel(entity.getPesel());
        dto.setBirthDate(entity.getBirthDate());
        dto.setPostalCode(entity.getPostalCode());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setState(entity.getState());
        dto.setHouseNumber(entity.getHouseNumber());
        dto.setApartmentNumber(entity.getApartmentNumber());
        dto.setGender(entity.getGender());
        dto.setDeclaredGender(entity.getDeclaredGender());
        dto.setMarketingConsent(entity.isMarketingConsent());
        dto.setEmailConsent(entity.isEmailConsent());
        return dto;
    }
}