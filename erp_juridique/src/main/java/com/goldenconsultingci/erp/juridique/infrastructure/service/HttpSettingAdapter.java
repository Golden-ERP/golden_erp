package com.goldenconsultingci.erp.juridique.infrastructure.service;

import com.goldenconsultingci.erp.common.JSONReader;
import com.goldenconsultingci.erp.juridique.domain.model.SettingService;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

public class HttpSettingAdapter implements SettingService {
    private static String SETTING_URI = "http://localhost:8080/settings/{name}";


    @Override
    public String isSettingHasValue(String aSetting, String aValue) {
        String body = this.makeRequest(aSetting);
        List<String> possibleValues = this.possibleValues(body);
        if (possibleValues.contains(aValue)) {
            return aValue;
        }
        return null;
    }

    private String makeRequest(String aSettingName) {
        String entity = null;
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(SETTING_URI).resolveTemplate("name", aSettingName);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        try (Response response = builder.get()){
            if (response.getStatus() == 200) {
                entity = response.readEntity(String.class);
            } else  if (response.getStatus() == 204) {
                // Retourne null. Ce n'est pas une erreur
            }
            else {
                throw new IllegalStateException(
                        "There was a probleme requesting the setting named "
                        + "named " + aSettingName
                        + " with response status "
                        + response.getStatus());
            }
        } finally {
            client.close();
        }
        return entity;
    }

    private List<String > possibleValues(String jsonString) {
        JSONReader reader = new JSONReader(jsonString);
        String possibleValues = reader.stringValue("possibleValues");
        String[] strings = possibleValues.split(";");
        return Arrays.asList(strings);
    }
}
