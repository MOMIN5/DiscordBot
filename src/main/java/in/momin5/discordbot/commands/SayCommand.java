package in.momin5.discordbot.commands;

import in.momin5.discordbot.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class SayCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        var message = event.getMessage().getContentRaw().split(Main.prefix +  "say");
        event.getChannel().sendMessage(message[1]).queue();

    }
}
