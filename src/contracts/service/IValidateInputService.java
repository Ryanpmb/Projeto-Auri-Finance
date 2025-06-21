package contracts.service;

public interface IValidateInputService {
    public boolean validateBirthDate(String date_of_birth);

    public boolean validatePhoneNumber(String phoneNumber);

    public boolean validateUserEmail(String email);

    public boolean validatePassword(String password, String confirmedPassword);

    public boolean validateUserCpf(String cpf);

    public boolean validateUserAddress(String address);
}
