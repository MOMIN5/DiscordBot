package in.momin5.discordbot.events;

import in.momin5.discordbot.Main;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Main.LOGGER.info(Main.LOGGER.getName() + " successfully started!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot())
            return;

        if(event.getMessage().getContentRaw().startsWith(Main.prefix)) {

            var commandName = event.getMessage().getContentRaw().substring(1);
            var channel = event.getChannel();
            var message = event.getMessage();

            if(commandName.equals("ping")){
                long currentTime = System.currentTimeMillis();
                message.reply("Calculating...").queue(message1 -> {
                    message1.editMessageFormat("%d ms",System.currentTimeMillis() - currentTime).queue();
                });
            }else if(commandName.equals("purge")) {
            }

        }
    }

    /*public void onSlashCommand(SlashCommandEvent event) {
        if(event.getName().equals("help")) {
            event.deferReply().queue();
            event.getHook().sendMessage("yo").queue(); // this works but isnt ready yet, im retarded i should have read the docs before deleting the whole slash command event
        }
    }*/
}
