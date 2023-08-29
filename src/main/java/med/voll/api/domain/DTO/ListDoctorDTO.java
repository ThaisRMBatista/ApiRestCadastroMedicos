package med.voll.api.domain.DTO;

import lombok.*;
import med.voll.api.domain.Doctor;
import med.voll.api.domain.enumType.Specialty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ListDoctorDTO {

    private String name;
    private String email;
    private String crm;
    private Specialty specialty;

    public ListDoctorDTO(Doctor doctor) {
        this(doctor.getName(),doctor.getEmail(),doctor.getCrm(),doctor.getSpecialty());
    }
}
