package burger;

//Класс для тестовых данных - так как в параметризации не вижу смысла отдельно пропишу данные)
public class UserTestValues {

    public static String nameHank = "Hank";
    public static String emailHank = "hank_j_wimbleton67@mail.ru";
    public static String passwordHank7symbols = "azino77";
    public static String passwordHank6symbols = "azino7";

    public static String invalidPasswordHank5symbols = "azino";


    public static UserCard validUserHank7symbols = new UserCard(nameHank, emailHank, passwordHank7symbols);
    public static UserCard userHankEmailPass6symbols = new UserCard(emailHank, passwordHank6symbols);
    public static UserCard userHankEmailPass7symbols = new UserCard(emailHank, passwordHank7symbols);

}
