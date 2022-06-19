package io.github.rysefoxx.command;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class ButtonObject extends ListenerAdapter {

    public List<Button> buttons() {
        return new ArrayList<>();
    }

    public void onButtonClick(@NotNull ButtonInteractionEvent event) {
    }
}
