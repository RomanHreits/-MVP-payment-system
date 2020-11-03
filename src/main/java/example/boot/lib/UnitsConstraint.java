package example.boot.lib;

import example.boot.validator.UnitValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UnitValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitsConstraint {
    String message() default "Please, enter correct number of units!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
