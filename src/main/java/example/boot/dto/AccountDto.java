package example.boot.dto;

import example.boot.lib.UnitsConstraint;
import lombok.Data;

@Data
public class AccountDto {
    private String accountNumber;
    @UnitsConstraint
    private long units;
}
