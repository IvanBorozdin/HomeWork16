package ru.skepro.homework17.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.skepro.homework17.exception.InvalidEmployeeDataException;
import ru.skepro.homework17.service.EmployeeValidationService;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeValidationServiceimpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName,String lastName){
        validateName(firstName);
        validateName(lastName);

    }
    private void validateName(String name) {
        if (!isAlpha(name)){

            throw new InvalidEmployeeDataException();

        }

    }
}
