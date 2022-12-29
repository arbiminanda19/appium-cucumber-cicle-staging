package api;

import org.json.simple.JSONObject;

import java.util.Random;

public class data {

    Random rand = new Random();

    String teamName = "team" + rand.nextInt(1000);
    String companyId = "61eba2c85080f47b25ddc8f8";

    public String getTeamName() {
        return teamName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public JSONObject createTeamData(){
        JSONObject payload = new JSONObject();
        String teamName = getTeamName();
        payload.put("name", teamName);
        payload.put("desc", "descccc");
        payload.put("type", "team");
        return payload;
    }

}
