package helper;

import api.baseUrl;
import api.data;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class requestAPI {

    baseUrl baseUrl = new baseUrl();
    data data = new data();
    accessFile accessFile = new accessFile();
    String file_token = "src/test/resources/data/token.txt";
    Random rand = new Random();
    String token = accessFile.readFromFile(file_token);

    public String getCompanyName() {

        RestAssured.baseURI = baseUrl.getStagingCicle();


        JSONObject payload = data.createTeamData();

        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(payload.toJSONString())
                .post("/api/v1/teams?companyId=" + data.getCompanyId())
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        JsonPath responseParsed = response.jsonPath();
        Assert.assertEquals(data.getTeamName(), responseParsed.getString("newTeam.name"));
        return responseParsed.getString("newTeam.boards[0]");

    }

}
