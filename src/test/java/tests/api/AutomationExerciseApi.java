package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AutomationExerciseApi {
    @BeforeMethod
    public void setUrl(){
        RestAssured.baseURI = "https://automationexercise.com/api";
    }
    @Test
    public void getAllProductsList(){
        Response response = given().
                contentType(ContentType.JSON).
                when().
                get("/productsList").
                then().
                extract().response();
        Assert.assertEquals(response.getStatusCode(),200,"status code should be 200");
    }
    @Test
    public void getAllBrandsList(){
        Response response = given().
                contentType(ContentType.JSON).
                when().
                get("/brandsList").
                then().
                extract().response();
        Assert.assertEquals(response.getStatusCode(),200,"status code should be 200");
    }
    @Test
    public void getUserAccountDetailByEmail(){
        Response response = given().
                when().
                contentType(ContentType.JSON).
                queryParam("email","neda123@neda.com").
                get("/getUserDetailByEmail").
                then().
                extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(),200,"status code should be 200");
    }
    @Test(priority = 1)
    public void postRegisterUserAccount(){
        Response response = given().
               contentType("application/x-www-form-urlencoded")
                .formParam("name", "Ovan")
                .formParam("email", "ovan1234@test.com")
                .formParam("password", "bibilibi1234")
                .formParam("title", "Mr")
                .formParam("birth_date", "01")
                .formParam("birth_month", "June")
                .formParam("birth_year", "1994")
                .formParam("firstname", "Jovan")
                .formParam("lastname", "Nini")
                .formParam("company", "TestCompany")
                .formParam("address1", "Bb 21")
                .formParam("address2", "Apartment 5")
                .formParam("country", "Canada")
                .formParam("zipcode", "12345")
                .formParam("state", "Alberta")
                .formParam("city", "Calgary")
                .formParam("mobile_number", "3847473632")
                .when()
                .post("/createAccount")
                .then()
                .extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 201);
        Assert.assertEquals(response.jsonPath().getString("message"), "User created!");
    }
    @Test(priority = 2)
    public void putUpdateAccount(){
        Response response = given().
                contentType("application/x-www-form-urlencoded")
                .formParam("name", "Ovan")
                .formParam("email", "ovan1234@test.com")
                .formParam("password", "bibilibi1234")
                .formParam("title", "Mrs")
                .formParam("birth_date", "02")
                .formParam("birth_month", "July")
                .formParam("birth_year", "1992")
                .formParam("firstname", "Ovan")
                .formParam("lastname", "Nini")
                .formParam("company", "TestCompany")
                .formParam("address1", "Bb 21")
                .formParam("address2", "Apartment 5")
                .formParam("country", "Canada")
                .formParam("zipcode", "12345")
                .formParam("state", "Alberta")
                .formParam("city", "Calgary")
                .formParam("mobile_number", "3847473632")
                .when()
                .put("/updateAccount")
                .then()
                .extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "User updated!");
    }
    @Test(priority = 3)
    public void getVerifyUserDetailsUpdated(){
        Response response = given().
                when().
                contentType(ContentType.JSON).
                queryParam("email","ovan1234@test.com").
                get("/getUserDetailByEmail").
                then().
                extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(),200,"status code should be 200");
    }
    @Test(priority = 4)
    public void deleteUser(){
        Response response = given().
                when().
                contentType("application/x-www-form-urlencoded").
                formParam("email","ovan1234@test.com").
                formParam("password","bibilibi1234").
                delete("/deleteAccount").
                then().
                extract().response();
        Assert.assertEquals(response.getStatusCode(),200,"status code should be 200");
        Assert.assertEquals(response.jsonPath().getString("message"), "Account deleted!");
    }
    @Test(priority = 5)
    public void getVerifyIfUserDeleted(){
        Response response = given().
                when().
                contentType(ContentType.JSON).
                queryParam("email","ovan1234@test.com").
                get("/getUserDetailByEmail").
                then().
                extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),404,"User not found!");
    }
    @Test
    public void postLoginUser(){
        Response response = given().
                contentType("application/x-www-form-urlencoded")
                .formParam("email", "neda123@neda.com")
                .formParam("password", "testtest123")
                .when()
                .post("/verifyLogin")
                .then()
                .extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "User exists!");
    }
    @Test
    public void postLoginInvalidPassword(){
        Response response = given().
                contentType("application/x-www-form-urlencoded")
                .formParam("email", "neda123@neda.com")
                .formParam("password", "testtesting")
                .when()
                .post("/verifyLogin")
                .then()
                .extract().response();
        System.out.println(response.asString());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 404);
        Assert.assertEquals(response.jsonPath().getString("message"), "User not found!");
    }
    @Test
    public void postSearchProducts(){
        Response response = given().
                contentType("application/x-www-form-urlencoded")
                .formParam("search_product", "top")
                .when()
                .post("/searchProduct")
                .then()
                .extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200);
        List<Map<String,Object>> searchedProducts = response.jsonPath().getList("products");
        Assert.assertTrue(searchedProducts.size()>0,"Product list should not be empty!");
    }

}
