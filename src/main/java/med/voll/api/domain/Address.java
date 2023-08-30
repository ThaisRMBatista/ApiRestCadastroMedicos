package med.voll.api.domain;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.domain.DTO.AddressDTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {

    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.getStreet();
        this.neighborhood = addressDTO.getNeighborhood();
        this.zipCode = addressDTO.getZipCode();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.complement = addressDTO.getComplement();
        this.number = addressDTO.getNumber();
    }

    public void updateData(AddressDTO addressDTO) {
        if (addressDTO.getStreet() != null) {
            this.street = addressDTO.getStreet();
        }
        if (addressDTO.getNeighborhood() != null) {
            this.neighborhood = addressDTO.getNeighborhood();
        }
        if (addressDTO.getZipCode() != null) {
            this.zipCode = addressDTO.getZipCode();
        }
        if (addressDTO.getCity() != null) {
            this.city = addressDTO.getCity();
        }
        if (addressDTO.getState() != null) {
            this.state = addressDTO.getState();
        }
        if (addressDTO.getComplement() != null) {
            this.complement = addressDTO.getComplement();
        }
        if (addressDTO.getNumber() != null) {
            this.number = addressDTO.getNumber();
        }
    }
}
