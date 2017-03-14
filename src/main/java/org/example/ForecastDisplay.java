package org.example;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import com.vaadin.data.ValueProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.example.domain.Forecast;
import org.example.domain.ForecastResponse;

/**
 *
 * @author Matti Tahvonen <matti@vaadin.com>
 */
public class ForecastDisplay extends Grid<Forecast> {

    String captionTemplate = "Tomorrow in %s there will be %s";

    public void setForecast(ForecastResponse fr) {
        setCaption(
                String.format(captionTemplate,
                    fr.getCity().getName(),
                    fr.getList().get(0).getWeather().get(0).
                    getDescription())
        );

        removeAllColumns();
        addColumn(fc -> {
            int day = fr.getList().indexOf(fc);
            return LocalDate.now().plusDays(day);
        }).setCaption("Day");
        addColumn(fc -> fc.getTemp().getDay() + "° C").setCaption("Temp");
        addColumn(fc -> fc.getWeather().get(0).getDescription()).setCaption("Description");

        setItems(fr.getList());
    }

}
