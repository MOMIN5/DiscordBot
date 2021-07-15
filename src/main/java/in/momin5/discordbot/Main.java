package in.momin5.discordbot;

import in.momin5.discordbot.events.Listener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final String TOKEN = "";
    public static final Logger LOGGER = LoggerFactory.getLogger("MominBot");
    public static final String prefix = "/";


    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try {
            JDA jda = JDABuilder.createLight(TOKEN)
                    .addEventListeners(new Listener())
                    .setActivity(Activity.playing("idk some cool shit"))
                    .build();


        }catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }


}
