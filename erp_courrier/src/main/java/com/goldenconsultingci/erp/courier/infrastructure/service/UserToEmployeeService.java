package com.goldenconsultingci.erp.courier.infrastructure.service;

import com.goldenconsultingci.erp.common.JSONReader;
import com.goldenconsultingci.erp.courier.domain.EmployeeService;
import com.goldenconsultingci.erp.courier.domain.ShareHolder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class UserToEmployeeService implements EmployeeService {
    private static String URI = "http://localhost:8080/iam/actors/{username}/inSite/{siteId}";
    @Override
    public ShareHolder shareHolderFrom(String identity, String aSiteId) {
        ShareHolder shareHolder =  null;
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(URI)
                .resolveTemplate("username", identity)
                .resolveTemplate("siteId", aSiteId);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        try (Response response = builder.get()){
            if (response.getStatus() == 200) {
                String entity = response.readEntity(String.class);
                 shareHolder =this.toShareHolder(entity);
            } else if (response.getStatus() == 204) {
                System.out.println("NOT Found");
                return null;
            }
        }  finally {
            client.close();
        }
        return shareHolder;
    }

    @Override
    public ShareHolder employeeFromResponsibility(String aResponsibility, String aSiteId) {
        String URI = "http://localhost:8080/iam/actors/inResponsibility/{responsibility}/site/{siteId}";
        ShareHolder shareHolder =  null;
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(URI)
                .resolveTemplate("responsibility", aResponsibility)
                .resolveTemplate("siteId", aSiteId);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        try (Response response = builder.get()){
            if (response.getStatus() == 200) {
                String entity = response.readEntity(String.class);
                shareHolder =this.toShareHolder(entity);
            } else if (response.getStatus() == 204) {
                System.out.println("NOT Found");
                return null;
            }
        }  finally {
            client.close();
        }
        return shareHolder;
    }

    private ShareHolder toShareHolder(String aValue) {
        JSONReader reader = new JSONReader(aValue);
        String username = reader.stringValue("username");
        String firstName = reader.stringValue("firstName");
        String lastName = reader.stringValue("lastName");
        String siteId = reader.stringValue("siteId");
        String responsibility = reader.stringValue("responsibility");
        return new  ShareHolder(username, responsibility, firstName + " " + lastName, siteId);
    }
}
