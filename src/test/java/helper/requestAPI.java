package helper;

import api.baseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class requestAPI {

    baseUrl baseUrl = new baseUrl();
    accessFile accessFile = new accessFile();
    String file_token = "src/test/resources/data/token.txt";
    Random rand = new Random();
    String token = accessFile.readFromFile(file_token);

    public String getCompanyId() {

        RestAssured.baseURI = baseUrl.getStagingCicle();

        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .get("/companies")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        JsonPath responseParsed = response.jsonPath();
        List companyList = responseParsed.getList("companies");
        return responseParsed.getString("companies[" + (companyList.size()-1) + "]._id");

    }

    public void deleteCompany(String companyId) {

        RestAssured.baseURI = baseUrl.getStagingCicle();

        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .delete("/companies/" + companyId)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

    }

}
