package demo.auzmor.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="account")
@Getter
public class Account {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(generator="account_id_generator")
    @SequenceGenerator(
            name = "account_id_generator",
            sequenceName = "account_id_sequence"
    )
    private Integer id;

    @Column(name = "auth_id")
    @Size(max = 40)
    private String authId;

//    private String password;

    @Column(name = "username")
    @Size(max = 30)
    private String username;

    public void setAuthId(String authId) {
        this.authId = PASSWORD_ENCODER.encode(authId);
    }
}
