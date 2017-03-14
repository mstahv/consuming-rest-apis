package org.example;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.inject.Inject;

/**
 * A simple example how to consume REST apis with JAX-RS and display that in 
 * a Vaadin UI.
 */
@CDIUI("")
public class VaadinUI extends UI {

    @Inject
    JsonService service;
    ForecastDisplay display = new ForecastDisplay();
    NativeSelect<String> citySelector = new NativeSelect<>("Choose city");

    @Override
    protected void init(VaadinRequest request) {
        citySelector.setEmptySelectionAllowed(false);
        citySelector.setItems("Turku", "San Francisco", "London");
        citySelector.addValueChangeListener( e-> {
            // Note, if you rest service may take a while make it "asynchronously"
            // using e.g. ProgressIndicator
            display.setForecast(service.getForecast(e.getValue()));
        });
        citySelector.setValue("Turku");

        VerticalLayout layout = new VerticalLayout(
                new Label("<h1>Simple REST weather</h1>",ContentMode.HTML),
                citySelector);
        layout.addComponentsAndExpand(display);
        setContent(layout);
    }


}
