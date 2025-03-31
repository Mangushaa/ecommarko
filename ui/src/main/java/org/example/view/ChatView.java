package org.example.view;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.UIScope;
import org.example.integration.RecommendationIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@UIScope
@Component
public class ChatView extends VerticalLayout {

    private RecommendationIntegrationService recommendationIntegrationService;

    @Autowired
    public ChatView(RecommendationIntegrationService recommendationIntegrationService) {
        this.recommendationIntegrationService = recommendationIntegrationService;
        MessageInput input = new MessageInput();
        TextArea textArea = new TextArea();
        textArea.setLabel("Response");
        textArea.setMaxLength(100);
        textArea.setVisible(false);
        textArea.setValueChangeMode(ValueChangeMode.ON_CHANGE);
        textArea.setWidth(100, Unit.PERCENTAGE);
        textArea.setHeight(100, Unit.PERCENTAGE);
        input.addSubmitListener(submitEvent -> {
            String recommendations = recommendationIntegrationService.getRecommendations(submitEvent.getValue());
            textArea.setVisible(true);
            textArea.setValue(recommendations);
        });
        add(textArea);
        add(input);
    }
}
