package med.voll.api.domain;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.DTO.DoctorDTO;
import med.voll.api.domain.DTO.UpdateDoctorDTO;
import med.voll.api.domain.enumType.Specialty;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "doctors")
@Entity(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private Boolean active;

    public Doctor(DoctorDTO doctorDTO) {
        this.active = true;
        this.name = doctorDTO.getName();
        this.email = doctorDTO.getEmail();
        this.telephone = doctorDTO.getTelephone();
        this.crm = doctorDTO.getCrm();
        this.specialty = doctorDTO.getSpecialty();
        this.address = new Address(doctorDTO.getAddressDTO());
    }

    public void updateData(UpdateDoctorDTO doctorDTO) {
        if (doctorDTO.getName() != null) {
            this.name = doctorDTO.getName();
        }
        if (doctorDTO.getTelephone() != null) {
            this.telephone = doctorDTO.getTelephone();
        }
        if (doctorDTO.getAddressDTO() != null) {
            this.address.updateData(doctorDTO.getAddressDTO());
        }
    }

    public void remove() {
        this.active = false;
    }
}
