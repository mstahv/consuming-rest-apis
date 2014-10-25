
package org.example.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

public class City {

    private Integer id;
    private String name;
    private Coord coord;
    private String country;
    private Integer population;
    private Map<String,String> sys = new HashMap<>();

    public Map<String, String> getSys() {
        return sys;
    }

    public void setSys(Map<String, String> sys) {
        this.sys = sys;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

}
