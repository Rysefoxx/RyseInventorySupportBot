package io.github.rysefoxx;

import io.github.rysefoxx.command.CommandManager;
import io.github.rysefoxx.document.Document;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.Contract;

import javax.security.auth.login.LoginException;

/**
 * @author Rysefoxx | Rysefoxx#6772
 * @since 6/18/2022
 */
public class SupportBot {

    private static JDA bot;

    public static void main(String[] args) {
        initBot();
    }

    private static void initBot() {
        JDABuilder builder = JDABuilder.createDefault(Document.get("BOT_TOKEN"));
        builder.setActivity(Activity.playing("Helps players with problems."));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        CommandManager commandManager = new CommandManager();

        try {
            builder.addEventListeners(commandManager);
            bot = builder.build().awaitReady();
        } catch (InterruptedException | LoginException e) {
            throw new RuntimeException(e);
        }
        commandManager.load();
    }

    @Contract(pure = true)
    public static JDA getBot() {
        return bot;
    }
}
