package io.github.rysefoxx.command;

import io.github.rysefoxx.SupportBot;
import io.github.rysefoxx.command.impl.InfoCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandManager extends ListenerAdapter {

    private final List<CommandObject> list = new ArrayList<>();

    public void load() {
        this.list.add(new InfoCommand());

        CommandListUpdateAction commands = SupportBot.getBot().updateCommands();

        for (CommandObject object : list)
            commands = commands.addCommands(object.getCommand());

        commands.queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        for (CommandObject object : list) {
            if (!object.getCommand().getName().equalsIgnoreCase(event.getInteraction().getName())) {
                continue;
            }

            object.respond(event);
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        for (CommandObject object : list) {
            object.buttons().forEach(button -> {
                if (!Objects.equals(button.getId(), event.getInteraction().getButton().getId()))
                    return;

                object.onButtonClick(event);
            });
        }
    }
}