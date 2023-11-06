package api.endpoints;

/**
 * Swagger URI => https://petstore.swagger.io
 * <p>
 * Create user(Post) => https://petstore.swagger.io/v2/user
 * Get user (Get) => https://petstore.swagger.io/v2/user/{username}
 * Update user (Put) => https://petstore.swagger.io/v2/user/{username}
 * Delete user (Delete) => https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {
    public static String baseUrl = "https://petstore.swagger.io/v2";
    //User Module
    public static String userEndpoint = baseUrl + "/user/";

    //Store Module
    public static String storePostUrl = baseUrl + "/store/order/";

}
