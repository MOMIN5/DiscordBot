package in.momin5.discordbot.events;

import in.momin5.discordbot.Main;
import in.momin5.discordbot.commands.PingCommand;
import in.momin5.discordbot.commands.PurgeCommand;
import in.momin5.discordbot.commands.SayCommand;
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

            if(commandName.startsWith("ping")){
                PingCommand.onMessageReceived(event);

            }else if(commandName.startsWith("purge")) {
                PurgeCommand.onMessageReceived(event);

            }else if(commandName.startsWith("say")) {
                SayCommand.onMessageReceived(event);
            }

        }
    }

}
