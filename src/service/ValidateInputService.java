package service;

import contracts.service.IValidateInputService;

public class ValidateInputService implements IValidateInputService{
    @Override
    public boolean validateBirthDate(String date_of_birth)
    {
        return date_of_birth.charAt(2) != '/' || date_of_birth.charAt(5) != '/' || date_of_birth.trim().length() < 10;
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber)
    {
        return phoneNumber.trim().length() < 11 || !phoneNumber.matches("^\\d{10,11}$");
    }

    @Override
    public boolean validateUserEmail(String email)
    {
        return email.trim().length() < 20 || !email.contains("@") || !email.contains(".com");
    }

    @Override
    public boolean validatePassword(String password, String confirmedPassword)
    {
        return password.trim().length() < 8 || password != confirmedPassword;
    }

    @Override
    public boolean validateUserCpf(String cpf) 
    {
        return cpf.trim().length() < 11 || cpf.matches(".*[a-zA-Z].*");
    }

    public boolean validateUserAddress(String address)
    {
        return address.trim().length() < 2;
    }
}
