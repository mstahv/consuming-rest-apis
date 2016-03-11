package org.example;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.UI;
import javax.inject.Inject;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.layouts.MVerticalLayout;

/**
 * A simple example how to consume REST apis with JAX-RS and display that in 
 * a Vaadin UI.
 */
@CDIUI("")
@Theme("valo")
public class VaadinUI extends UI {

    @Inject
    JsonService service;
    ForecastDisplay display = new ForecastDisplay();
    NativeSelect citySelector = new NativeSelect("Choose city");

    @Override
    protected void init(VaadinRequest request) {

        citySelector.addItems("Turku", "San Francisco", "London");
        citySelector.addValueChangeListener(this::changeCity);
        citySelector.setValue("Turku");

        setContent(new MVerticalLayout(
                        new Header("Simple REST weather"),
                        citySelector,
                        display
                )
        );
    }

    public void changeCity(Property.ValueChangeEvent e) {
        // Note, if you rest service may take a while make it "asynchronously"
        // using e.g. ProgressIndicator
        display.setForecast(service.getForecast(citySelector.getValue().toString()));
    }

}
