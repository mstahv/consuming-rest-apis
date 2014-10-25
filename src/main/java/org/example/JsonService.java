package org.example;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.example.domain.ForecastResponse;

/**
 */
@ApplicationScoped
public class JsonService {

    private Client client;
    private WebTarget target;

    @PostConstruct
    protected void init() {
        client = ClientBuilder.newClient();
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric
        target = client.target(
                "http://api.openweathermap.org/data/2.5/forecast/daily").queryParam("cnt", "10")
                .queryParam("mode", "json")
                .queryParam("units", "metric");
    }

    public ForecastResponse getForecast(String place) {
        return target.queryParam("q", place)
                .request(MediaType.APPLICATION_JSON)
                .get(ForecastResponse.class);
    }
}
