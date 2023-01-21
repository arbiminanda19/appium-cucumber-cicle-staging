package runner;

import helper.requestAPI;
import org.junit.Test;

public class runAPI {

    static requestAPI requestAPI = new requestAPI();
    public static void main(String[] args) {
        for (int i =0; i < 20; i++) {
            String companyId = requestAPI.getCompanyId();
            requestAPI.deleteCompany(companyId);
        }
    }

}
