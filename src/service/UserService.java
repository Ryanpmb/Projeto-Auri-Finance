package service;

import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import contracts.repository.IUserRepository;
import contracts.service.IUserService;
import contracts.service.IValidateInputService;
import model.User;

public class UserService implements IUserService {
    private IValidateInputService validateInputService;
    private IUserRepository userRepository;

    public UserService(IValidateInputService validateInputService, IUserRepository userRepository){
        this.validateInputService = validateInputService;
        this.userRepository = userRepository;
    }

    @Override
    public User create(Scanner scanner, User user)
    {
        try {
            user.setName(this.registerUserName(scanner));
            user.setDate_of_birth(this.registerUserDateOfBirth(scanner));
            user.setPhone_number(this.registerUserPhoneNumber(scanner));
            user.setEmail(this.registerUserEmail(scanner));
            user.setPassword(this.registerUserPassword(scanner));
            user.setRoleId(this.registerUserRole(user));
            user.setCpf(this.registerUserCpf(scanner));
            user.setAddress(this.registerUserAdress(scanner));
            
            return this.userRepository.create(user);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o usuário: " + e.getMessage());
        }

    }

    public List<User> listUsers()
    {
        return this.userRepository.findMany();
    }

    private String registerUserName(Scanner scanner)
    {
        String name;

        do{
            System.out.println("Digite seu nome: ");
            name = scanner.next();
            if(name.trim().length() < 2){
                System.out.println("Nome inválido");
            }
        }while(name.trim().length() < 2);

        return name;
    }

    private String registerUserDateOfBirth(Scanner scanner)
    {
        String date_of_birth;

        do{
            System.out.println("Digite sua data de nascimento: ");
            date_of_birth = scanner.next();
            if(this.validateInputService.validateBirthDate(date_of_birth)){
                System.out.println("Data de nascimento inválida!");
                System.out.println("Digite uma data de nascimento válida.(ex: dd/mm/aaaa)");
            }
        }while (this.validateInputService.validateBirthDate(date_of_birth));

        return date_of_birth;
    }

    private String registerUserPhoneNumber(Scanner scanner)
    {
        String phoneNumber;

        do{
            System.out.println("Digite o seu número de telefone: ");
            phoneNumber = scanner.next();
            if (this.validateInputService.validatePhoneNumber(phoneNumber)) {
                System.out.println("Número de telefone inválido");
            }

        }while(this.validateInputService.validatePhoneNumber(phoneNumber));

        return phoneNumber;
    }

    private String registerUserEmail(Scanner scanner)
    {
        String email;
        do{
            System.out.println("Digite seu email: ");
            email = scanner.next();
            if(this.validateInputService.validateUserEmail(email)){
                System.out.println("Email inválido");
            }
        }while(this.validateInputService.validateUserEmail(email));

        return email;
    }

    private String registerUserPassword(Scanner scanner)
    {
        String password;
        String confirmedPassword;

        do{
            System.out.println("Digite sua senha: ");
            password = scanner.next();
            System.out.println("Confirme sua senha: ");
            confirmedPassword = scanner.next();
            if (this.validateInputService.validatePassword(password, confirmedPassword)) {
                System.out.println("Sua senha tem menos de 8 digítos ou a senha e a confirmação não batem");
            }
        }while(this.validateInputService.validatePassword(password, confirmedPassword));

        return password;
    }

    private int registerUserRole(User user)
    {
        if (user.getEmail().contains("grupoauri")) {
            return 1;
        }

        return 2;
    }

    private String registerUserCpf(Scanner scanner)
    {
        String cpf;
        do{
            System.out.println("Digite seu cpf: ");
            cpf = scanner.next();
            if (this.validateInputService.validateUserCpf(cpf)) {
                System.out.println("Cpf inválido!");
            }
        }while(this.validateInputService.validateUserCpf(cpf));

        return cpf;
    }

    private String registerUserAdress(Scanner scanner)
    {
        String address;

        do{
            System.out.println("Digite seu endereço: ");
            address = scanner.next();

            if (this.validateInputService.validateUserAddress(address)) {
                System.out.println("Endereço inválido!");
            }
        }while(this.validateInputService.validateUserAddress(address));

        return address;
    }

}
