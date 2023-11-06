package api.Tests;

import api.endpoints.Base;
import api.endpoints.Routes;
import api.payload.User;
import api.utilities.Logs;
import api.utilities.XLUtility;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

    @Listeners(api.utiliti.Listeners.class)
public class DDUserTest extends Base {

    Faker faker;
    Base base;
    XLUtility xlExpectedData, xlTestData;

    @BeforeClass(description = "Prepare data for testing")
    public void setupData() throws IOException {
        base = new Base();
        faker = new Faker();
        Logs.info("Get test data excel sheet path");
        xlTestData = new XLUtility(System.getProperty("user.dir") + "//testData//user_test_data.xlsx", "sheet1");
        Logs.info("Get expected data excel sheet path");
        xlExpectedData = new XLUtility(System.getProperty("user.dir") + "//testData//expectedData.xlsx", "sheet1");

    }

    @Test(priority = 1, description = "Create new user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create new user with valid request body ")
    @Step("Payload for create user : ")
    public void testCreateUser() {
        User userPayload = new User();
        userPayload.setId(Integer.parseInt(xlTestData.getData(1, 0)));
        userPayload.setUsername(xlTestData.getData(1, 1));
        userPayload.setFirstName(xlTestData.getData(1, 2));
        userPayload.setLastName(xlTestData.getData(1, 3));
        userPayload.setPassword(xlTestData.getData(1, 4));
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        Response response = base.postRequest(Routes.userEndpoint, userPayload);
        response.then().log().all();
        Logs.info("Validate create new user status");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, description = "Get user ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get created user data")
    public void TestReadUser() {
        Response response = base.getRequest(Routes.userEndpoint + xlTestData.getData(1, 1));
        response.then().log().all();
        System.out.println(response.jsonPath().getInt("id"));
        Logs.info("Validate get user status");
        Assert.assertEquals(response.getStatusCode(), 200);
        Logs.info("Validate user name from response should be " + xlExpectedData.getData(1, 1));
        Assert.assertEquals(response.jsonPath().getString("username"), xlExpectedData.getData(1, 1));

    }

    @Test(priority = 3, description = " Update user ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Update created user")
    @Step("Payload for update user : ")
    public void testUpdateUser() {
        User userPayload = new User();
        userPayload.setUsername(xlTestData.getData(2, 1));
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        Response response = base.putRequest(Routes.userEndpoint + xlTestData.getData(1, 1), userPayload);
        response.then().log().all();
        Logs.info("Validate update user status");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
