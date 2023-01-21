package runner;

import helper.requestAPI;
import org.junit.Test;

public class runAPI {

    static requestAPI requestAPI = new requestAPI();
    public static void main(String[] args) {
        String companyId = requestAPI.getCompanyId();
        requestAPI.deleteCompany(companyId);
    }

}
