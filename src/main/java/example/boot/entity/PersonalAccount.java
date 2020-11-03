package example.boot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personal_accounts")
@Data
@NoArgsConstructor
public class PersonalAccount {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "personal_account_id")
    private User user;
    private String accountNumber;
    private long units;

    public PersonalAccount(User user, String accountNumber, long units) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.units = units;
    }
}
