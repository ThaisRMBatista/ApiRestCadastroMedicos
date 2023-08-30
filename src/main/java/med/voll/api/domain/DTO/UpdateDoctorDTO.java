package med.voll.api.domain.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateDoctorDTO {

    @NotNull
    private Long id;
    private String name;
    private String telephone;
    private AddressDTO addressDTO;

}
