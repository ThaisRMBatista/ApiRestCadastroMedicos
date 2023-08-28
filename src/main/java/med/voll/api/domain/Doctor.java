package med.voll.api.domain;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.DTO.DoctorDTO;
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

    public Doctor(DoctorDTO doctorDTO) {
        this.name = doctorDTO.getName();
        this.email = doctorDTO.getEmail();
        this.telephone = doctorDTO.getTelephone();
        this.crm = doctorDTO.getCrm();
        this.specialty = doctorDTO.getSpecialty();
        this.address = new Address(doctorDTO.getAddressDTO());
    }
}
