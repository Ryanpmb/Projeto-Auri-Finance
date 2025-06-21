import java.util.Scanner;

import contracts.repository.IUserRepository;
import contracts.seeders.IRoleSeeders;
import contracts.service.IUserService;
import contracts.service.IValidateInputService;
import database.ConnectionFactory;
import model.User;
import repository.CreateTableRepository;
import repository.UserRepository;
import seeders.RoleSeeders;
import service.UserService;
import service.ValidateInputService;

public class App {
    public static void main(String[] args) {
        var connection = ConnectionFactory.getConnection();
        var createTableRepository = new CreateTableRepository(connection);
        IValidateInputService validateInputService = new ValidateInputService();
        IUserRepository userRepository = new UserRepository(connection);
        IUserService userService = new UserService(validateInputService, userRepository);
        IRoleSeeders roleSeeders = new RoleSeeders(connection);
        Scanner scanner = new Scanner(System.in);
        int userOption;

        do{
            menu();
            userOption = scanner.nextInt();

            switch (userOption) {
                case 1:
                    createTableRepository.CreateRoleTable();
                    createTableRepository.CreateUserTable();
                    createTableRepository.CreateUserBankAccounteTable();
                    createTableRepository.CreatePermissionTable();
                    createTableRepository.CreatePermissionRoleTable();
                    roleSeeders.run();

                    System.out.println("Sistema configurado com sucesso!");
                    break;
            
                case 2:
                    User user = new User();
                    userService.create(scanner, user);
                    break;
            }
        }while(userOption != 10);

        
    }

    public static void menu()
    {
        System.out.println("--------------Bem vindo a Auri--------------");
        System.out.println("1- Primeira vez acessando(é necessário fazer este primeiro passo)");
        System.out.println("2- Cadastrar-se");
        
    }
}
