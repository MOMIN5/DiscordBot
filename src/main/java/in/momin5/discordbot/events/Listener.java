package in.momin5.discordbot.events;

import in.momin5.discordbot.Main;
import in.momin5.discordbot.commands.PingCommand;
import in.momin5.discordbot.commands.PurgeCommand;
import net.dv8tion.jda.api.events.ReadyEvent;
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
            var commandName = event.getMessage().getContentRaw().substring(1).toLowerCase();

            if(commandName.equals("ping")){
                new PingCommand().onMessageReceived(event);

            }else if(commandName.equals("purgee")) {
                new PurgeCommand().onMessageReceived(event);

            }

        }
    }

}
