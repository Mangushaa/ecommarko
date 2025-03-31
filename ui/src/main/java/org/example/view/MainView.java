package org.example.view;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;


@UIScope
@Component
@Route("main")
public class MainView extends VerticalLayout {

    private ChatView chatView;

    public MainView(ChatView chatView) {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(100, Unit.PERCENTAGE);
        setAlignItems(Alignment.CENTER);
        add(chatView);
    }
}
