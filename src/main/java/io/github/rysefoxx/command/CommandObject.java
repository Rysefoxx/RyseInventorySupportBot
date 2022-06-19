package io.github.rysefoxx.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public abstract class CommandObject extends ButtonObject {

    public abstract CommandData getCommand();

    public abstract void respond(SlashCommandInteractionEvent event);

}