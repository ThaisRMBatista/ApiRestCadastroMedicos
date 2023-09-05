package med.voll.api.infra.exception;

import lombok.*;
import org.springframework.validation.FieldError;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorHandlerDTO {
    private String campo;
    private String mensagem;

    public ErrorHandlerDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
