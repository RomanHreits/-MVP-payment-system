package example.boot.validator;

import example.boot.lib.UnitsConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnitValidator implements ConstraintValidator<UnitsConstraint, Long> {

    @Override
    public boolean isValid(Long units, ConstraintValidatorContext constraintValidatorContext) {
        return units != null && units > 0;
    }
}
