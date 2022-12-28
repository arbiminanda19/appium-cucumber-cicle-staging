package helper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class requestAPI {

    public String getCompanyName() {
        RestAssured.baseURI = "https://stagingapi.cicle.app";
        String token = "jwt eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Il9pZCI6IjYzNDdiOTBlNjk5YmMwNDg3MWE4NTJlZSIsImdvb2dsZUlkIjoiMTA4MjgwMDUwNDMxNTgzMjQzNDE2IiwiZW1haWwiOiJhcmJpbWluYW5kYTEwQGdtYWlsLmNvbSIsImZ1bGxOYW1lIjoiTXVoYW1tYWQgQXJiaSBNaW5hbmRhIiwicGhvdG9VcmwiOiJodHRwczovL3N0b3JhZ2UuZ29vZ2xlYXBpcy5jb20vc3RhZ2luZy1jaWNsZS1hcHAvNjM0N2I5MGU2OTliYzA0ODcxYTg1MmVlLzI2NmFlYjQ1YmNhOTNkNjgwYWYwNzQwYzkyOTAwMzc3L3Rlc3QxLndlYnAiLCJiaW8iOiJ0ZXN0Iiwic3RhdHVzIjoiTXVoYW1tYWQgQXJiaSBNaW5hbmRhX0lRQTE2IiwiZGVmYXVsdENvbXBhbnkiOnsiX2lkIjoiNjFlYmEyYzg1MDgwZjQ3YjI1ZGRjOGY4In0sImNyZWF0ZWRBdCI6IjIwMjItMTAtMTNUMDc6MDY6NTQuMjA4WiIsInVwZGF0ZWRBdCI6IjIwMjItMTEtMThUMTE6NTE6MzQuOTA3WiIsIl9fdiI6MH0sImlhdCI6MTY3MTc4NTIxNCwiZXhwIjoxNjc0Mzc3MjE0fQ.b6UJ63v4jS7REPnzuWFbb8sUaK93d6_-6cA9Yh6ZKzM";
        Random rand = new Random();

        JSONObject payload = new JSONObject();
        String teamName = "team" + rand.nextInt(1000);
        payload.put("name", teamName);
        payload.put("desc", "descccc");
        payload.put("type", "team");

        Response response = given()
                .when()
                //.body("{\"name\":\"team23Dec12\",\"desc\": \"desccccc\",\"type\":\"team\"}")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(payload.toJSONString())
                .post("/api/v1/teams?companyId=61eba2c85080f47b25ddc8f8")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        JsonPath responseParsed = response.jsonPath();
        Assert.assertEquals(teamName, responseParsed.getString("newTeam.name"));
        return responseParsed.getString("newTeam.boards[0]");

    }

}
