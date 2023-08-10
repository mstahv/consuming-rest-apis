
package org.example.domain;

import java.util.ArrayList;
import lombok.Data;

public class ForecastResponse {

    private String cod;
    private Double message;
    private City city;
    private Integer cnt;
    private java.util.List<Forecast> list = new ArrayList<>();

}
