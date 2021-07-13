package in.momin5.discordbot.events;

import in.momin5.discordbot.Main;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Main.LOGGER.info(Main.LOGGER.getName() + " successfully started!");
    }

    @Override
    public void onSlashCommand(SlashCommandEvent event) {

        String commandName = event.getName();

        if(commandName.equals("ping")){

            long currentTime = System.currentTimeMillis();

            event.reply("Calculating...").queue(message1 -> {
                message1.editOriginalFormat("%d ms",System.currentTimeMillis() - currentTime).queue();
            });

        }else if(event.getName().equals("purge")) {
            event.reply("hello").queue();

        }
    }
}
