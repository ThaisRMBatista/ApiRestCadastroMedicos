package med.voll.api.domain.DTO;

import lombok.*;
import med.voll.api.domain.enumType.Specialty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorDTO {

    private String name;
    private String email;
    private String crm;
    private Specialty specialty;
    private AddressDTO addressDTO;

}
