package med.voll.api.domain.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationDTO {

    private String login;
    private String password;

}
