package med.voll.api.domain.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import med.voll.api.domain.Address;
import med.voll.api.domain.Doctor;
import med.voll.api.domain.enumType.Specialty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailsDoctosDTO {

    @NotNull
    private Long id;
    private String name;
    private String email;
    private String crm;
    private Specialty specialty;
    private String telephone;
    private Address address;

    public DetailsDoctosDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty(), doctor.getTelephone(), doctor.getAddress());
    }
}
