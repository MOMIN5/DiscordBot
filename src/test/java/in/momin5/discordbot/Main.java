/*package in.momin5.discordbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageFlag;

public class Main {

    public static void main(String[] args) {

        String token = "ODA2MDk5MDUyNTY3NTkyOTkw.YBkgPg.YW6XSKaZ7a6dS5CicJ77zijNT_4";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addSlashCommandCreateListener(event -> {
            System.out.println("WORKS!!!");
           if(event.getSlashCommandInteraction().getCommandName().equals("ping")) {
                event.getSlashCommandInteraction().createImmediateResponder().setContent("HELLO").setFlags(MessageFlag.EPHEMERAL).respond();
            }
        });

        api.addMessageCreateListener(event -> {
           System.out.println("ok");
        });
    }
}
*/