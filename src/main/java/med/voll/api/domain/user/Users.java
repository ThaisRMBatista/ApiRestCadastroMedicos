package med.voll.api.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Users")
@Table(name = "users")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

}
