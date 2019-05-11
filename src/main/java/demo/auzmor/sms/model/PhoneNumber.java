package demo.auzmor.sms.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="phone_number")
@Getter
public class PhoneNumber {

    @Id
    @GeneratedValue(generator="account_id_generator")
    @SequenceGenerator(
            name = "account_id_generator",
            sequenceName = "account_id_sequence"
    )
    private Integer id;

    @Column(name = "number")
    private String number;

    @ManyToOne
    private Account account;
}
