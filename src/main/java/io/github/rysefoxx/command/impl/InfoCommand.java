package io.github.rysefoxx.command.impl;

import io.github.rysefoxx.command.CommandObject;
import io.github.rysefoxx.document.Document;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;


/**
 * @author Rysefoxx | Rysefoxx#6772
 * @since 6/19/2022
 */
public class InfoCommand extends CommandObject {

    @Override
    public CommandData getCommand() {
        return Commands.slash("info", "Sends an embed to the chat with possible options.");
    }

    @Override
    public void respond(@NotNull SlashCommandInteractionEvent event) {
        MessageChannel channel = event.getChannel();
        Member member = event.getMember();
        if (member == null) return;
        if (!member.isOwner()) return;

        if (!channel.getId().equals(Document.get("INFO_CHANNEL_ID"))) return;

        event.deferReply(true).queue();
        channel.sendMessageEmbeds(new EmbedBuilder()
                .setAuthor("RyseInventory", "https://github.com/Rysefoxx/RyseInventory", "https://i.imgur.com/BS3gwxL.png")
                .setFooter("RyseInventory - How you can improve RyseInventory", "https://i.imgur.com/BS3gwxL.png")
                .setTimestamp(Instant.now())
                .setDescription("What is RyseInventory?\n" +
                        "\n" +
                        "```\n" +
                        " - RyseInventory is a Minecraft API that allows you to create \n" +
                        "   inventory in a simplified way.\n" +
                        " - RyseInventory is opensource and includes a wiki for help.\n" +
                        " - Furthermore, there are many examples of the API.```")
                .addField("I have found a bug! <:3523win11erroicon:988154818864508980>", "``` I am very grateful for any error that is transmitted.\n" +
                        " To increase productivity and reduce duplicates, I ask you \n" +
                        " to check the channel #bugs for already known bugs \n" +
                        " beforehand. \n" +
                        "\n" +
                        " To report a bug, press the \"Bug\" button and follow the \n" +
                        " instructions.\n" +
                        "\n" +
                        " !Please follow these steps when reporting an error! \n" +
                        "  1) Please submit your Minecraft version that the server is \n" +
                        "     running on. \n" +
                        "  2) Please submit the error code.\n" +
                        "  3) Please include a brief description of what you are \n" +
                        "     trying to do. \n" +
                        "  4) Please briefly explain your code if it is difficult to \n" +
                        "     understand. ```", false)
                .addField("I have a new idea | suggestion for improvement <:thatsagoo_:988161222459424809>", "``` I am very grateful for new ideas or suggestions for \n" +
                        " improvement. \n" +
                        " Again, first check the #suggestions channel\n" +
                        " to see if your idea has already been suggested.\n" +
                        "\n" +
                        " To submit a suggestion, press the \"Suggestion\" button below\n" +
                        " and follow the instructions accordingly.\n" +
                        "\n" +
                        " !Please follow the design below to make sure\n" +
                        " your idea makes it to the development phase.!\n" +
                        " ---------------------------------------------\n" +
                        " Name=A method to empty the inventory. For example #clear()\n" +
                        "\n" +
                        " Description=In my situation, I often have to empty the \n" +
                        " inventory completely.\n" +
                        " Currently, I am going a completely complicated way to \n" +
                        " achieve this. Regarding this, I would ask you to add the \n" +
                        " #clear method to clear the inventory directly.\n" +
                        "\n" +
                        " Preview (Optional)= /\n" +
                        " Code Example (Optional)=I don't know anything about \n" +
                        " programming. \n" +
                        "```", false)
                .addField("I need help! <:help:988163019475406860>", "``` I am available to help, please note that 24 hour support is \n" +
                        " not possible. You will be helped when time is available.\n" +
                        "\n" +
                        " To request help, click the \"Help\" button below and follow \n" +
                        " the instructions. \n" +
                        "\n" +
                        " In order to help you quickly, I ask you to do the following:\n" +
                        "  1) Describe your problem well.\n" +
                        "  2) Link associated code.\n" +
                        "  3) Your problem description should not be something like \n" +
                        "     \"Method xy in the API is not working, please fix this.\"\n" +
                        "```", false)
                .addField("", "Thank you for using RyseInventory.", false)
                .setColor(Color.decode("#363e3e"))
                .build()
        ).setActionRow(buttons()).queue();
    }

    @Override
    public List<Button> buttons() {
        return Arrays.asList(
                Button.primary("Bug", "Report a bug"),
                Button.primary("Suggestion", "Submit a suggestion"),
                Button.primary("Help", "Request help"));
    }

    @Override
    public void onButtonClick(@NotNull ButtonInteractionEvent event) {
        String id = event.getButton().getId();

        if (id == null) return;
        event.deferEdit().queue();

        if (id.equals("Bug")) {
            event.getChannel().sendMessage("test").queue();
        }
    }
}
