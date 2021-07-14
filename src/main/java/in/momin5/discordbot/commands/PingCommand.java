package in.momin5.discordbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        var message = event.getMessage();

        long currentTime = System.currentTimeMillis();
        message.reply("Calculating...").queue(message1 -> {
            message1.editMessageFormat("%d ms",System.currentTimeMillis() - currentTime).queue();
        });

    }
}
