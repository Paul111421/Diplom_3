package burger;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;

public class UserApi {

    //Добавил отдельный API для чистки созданного пользователя - не стоит оставлять в тупую созданного пользователя

    private static String userAuthRegisterEndpoint = "/api/auth/register";
    private static String userAuthLoginEndpoint = "/api/auth/login";
    private static String userAuthFindOrDeleteEndpoint = "/api/auth/user";

    @Step("Создать нового пользователя (общий метод для других)")
    public static Response createUniqueUser(UserCard userCard){
        return given()
                .header("Content-Type", "application/json")
                .and()
                .body(userCard)
                .when()
                .post(userAuthRegisterEndpoint);
    }

    @Step("Проверить успешность создания нового пользователя (200 OK)")
    public static void createUniqueUser200(Response responseCreateUniqueUser){
        responseCreateUniqueUser.then().statusCode(SC_OK);
    }

    @Step("Авторизовать пользователя (общий для других метод)(необходимо сначала создать пользователя!!!")
    public static Response loginUniqueUserAfterCreatingUser(UserCard userCard){
        return given()
                .header("Content-Type","application/json")
                .and()
                .body(userCard)
                .when()
                .post(userAuthLoginEndpoint);
    }

    @Step("Извлечь токен авторизации пользователя")
    public static String extractBearerToken(Response responseCreateUniqueUser){
        return responseCreateUniqueUser.then().extract().path("accessToken").toString().replace("Bearer ","");
    }

    @Step("Найти нового пользователя")
    public static Response findUniqueUserByToken(Response responseCreateUniqueUser){
        String bearerToken = extractBearerToken(responseCreateUniqueUser);

        return given()
                .auth().oauth2(bearerToken)
                .when()
                .get(userAuthFindOrDeleteEndpoint);
    }

    @Step("Удалить нового пользователя")
    public static void deleteUniqueUserByToken(Response responseCreateUniqueUser){
        String bearerToken = extractBearerToken(responseCreateUniqueUser);

        Response responseDeleteUniqueUser = given()
                .auth().oauth2(bearerToken)
                .when()
                .delete(userAuthFindOrDeleteEndpoint);

        responseDeleteUniqueUser.then().statusCode(SC_ACCEPTED);
    }

    @Step("Метод для удаления пользователя, если тест его вызывает")
    public static void deleteUserInBurgerTest(UserCard userCard){
        Response responseLoginUniqueUser = loginUniqueUserAfterCreatingUser(userCard);
        if (responseLoginUniqueUser.statusCode() == SC_OK) {
            deleteUniqueUserByToken(responseLoginUniqueUser);
        } else{
            System.out.println();
        }
    }
}
