package org.example;

import java.util.Calendar;
import java.util.Date;
import org.example.domain.Forecast;
import org.example.domain.ForecastResponse;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MVerticalLayout;

/**
 *
 * @author Matti Tahvonen <matti@vaadin.com>
 */
public class ForecastDisplay extends MVerticalLayout {

    String mainTemplate = "Tomorrow in %s there will be %s";
    String detailTemplate = "### %tD \n %s°, %s";

    public ForecastDisplay() {
    }

    public void setForecast(ForecastResponse fr) {

        removeAllComponents();
        addComponents(
                new Header(String.format(mainTemplate,
                                fr.getCity().getName(),
                                fr.getList().get(0).getWeather().get(0).
                                getDescription()))
        );
        
        Calendar cal = Calendar.getInstance();
        for (Forecast f : fr.getList()) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date date = cal.getTime();
            Double temperature = f.getTemp().getDay();
            String desc = f.getWeather().get(0).getDescription();
            String md = String.format(detailTemplate, date, temperature, desc);
            addComponent(new RichText().withMarkDown(md));
        }
    }

}
