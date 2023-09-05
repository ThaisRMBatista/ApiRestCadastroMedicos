package med.voll.api.infra.security;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenJWTDTO {
    public String token;
}
