package com.tugas.TugasCRUD_KTP.util;


import org.springframework.stereotype.Component;
import jakarta.validation.*;
import java.util.Set;

@Component
public class ValidationUtil {

    private final Validator validator;

    public ValidationUtil() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
