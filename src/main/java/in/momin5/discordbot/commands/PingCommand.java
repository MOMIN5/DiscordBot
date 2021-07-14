package in.momin5.discordbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        var channel = event.getChannel();
        var message = event.getMessage();

        long currentTime = System.currentTimeMillis();
        message.reply("Calculating...").queue(message1 -> {
            message1.editMessageFormat("%d ms",System.currentTimeMillis() - currentTime).queue();
        });
    }
}
