package org.llpl.insurance_llpl.mapper;

import org.llpl.insurance_llpl.dto.PropertyDTO;
import org.llpl.insurance_llpl.model.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {

    public PropertyDTO toDTO(Property property) {
        if (property == null) {
            return null;
        }
        PropertyDTO dto = new PropertyDTO();
        dto.setId(property.getId());
        dto.setPostalCode(property.getPostalCode());
        dto.setCity(property.getCity());
        dto.setCountry(property.getCountry());
        dto.setStreet(property.getStreet());
        dto.setHouseNumber(property.getHouseNumber());
        dto.setApartmentNumber(property.getApartmentNumber());
        dto.setPropertyType(property.getPropertyType());
        dto.setPropertyValue(property.getPropertyValue());
        dto.setElectronicValue(property.getElectronicValue());
        dto.setArtValue(property.getArtValue());
        dto.setOtherValue(property.getOtherValue());
        dto.setArt(property.isArt());
        dto.setCash(property.isCash());
        dto.setCashValue(property.getCashValue());
        dto.setRented(property.isRented());
        dto.setGarage(property.isGarage());
        dto.setArea(property.getArea());
        dto.setConstructionYear(property.getConstructionYear());
        dto.setRoofType(property.getRoofType());
        dto.setHeatingType(property.getHeatingType());


        return dto;
    }

    public Property toEntity(PropertyDTO dto) {
        if (dto == null) {
            return null;
        }
        Property property = new Property();
        property.setPostalCode(dto.getPostalCode());
        property.setCity(dto.getCity());
        property.setCountry(dto.getCountry());
        property.setStreet(dto.getStreet());
        property.setHouseNumber(dto.getHouseNumber());
        property.setApartmentNumber(dto.getApartmentNumber());
        property.setPropertyType(dto.getPropertyType());
        property.setPropertyValue(dto.getPropertyValue());
        property.setElectronicValue(dto.getElectronicValue());
        property.setArt(dto.isArt());
        property.setArtValue(dto.getArtValue());
        property.setOtherValue(dto.getOtherValue());
        property.setCash(dto.isCash());
        property.setCashValue(dto.getCashValue());
        property.setRented(dto.isRented());
        property.setGarage(dto.isGarage());
        property.setArea(dto.getArea());
        property.setConstructionYear(dto.getConstructionYear());
        property.setRoofType(dto.getRoofType());
        property.setHeatingType(dto.getHeatingType());

        // Dodaj tutaj inne pola, jeśli istnieją w Twoich modelach.
        return property;
    }
}