package example.boot.dto;

import example.boot.lib.EmailConstraint;
import example.boot.lib.FieldsValueMatch;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@FieldsValueMatch(field = "password",
        fieldMatch = "repeatPassword")
public class UserRegistrationDto {
    @NotEmpty
    @EmailConstraint
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String repeatPassword;
}
