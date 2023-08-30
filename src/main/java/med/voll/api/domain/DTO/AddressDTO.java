package med.voll.api.domain.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {

    @NotBlank
    private String street;
    @NotBlank
    private String neighborhood;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String zipCode;
    @NotBlank
    private String city;
    @NotBlank
    private String state;

    private String complement;
    private String number;
}
