package demo.auzmor.sms.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="account")
public class Account {

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

    @Column(name = "username")
    @Size(max = 30)
    private String username;
}
