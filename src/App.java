import java.sql.Connection;

import contracts.repository.ICreateTable;
import database.ConnectionFactory;
import repository.CreateTableRepository;

public class App {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionFactory.getConnection();
        if (connection != null) {
            System.out.println("Conexão realizada com sucesso!");
            connection.close(); // Sempre feche a conexão após usar
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    }
}
