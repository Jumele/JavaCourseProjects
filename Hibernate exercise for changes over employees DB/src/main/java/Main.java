
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Interfata interfata = new Interfata();
        try {
            interfata.run();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}
