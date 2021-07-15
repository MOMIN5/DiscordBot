package in.momin5.discordbot.commands;

import in.momin5.discordbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.internal.utils.PermissionUtil;

import java.awt.*;

public class BanCommand {

    public static void onMessageReceived(MessageReceivedEvent event) {

        if(PermissionUtil.checkPermission(event.getMember(), Permission.BAN_MEMBERS, Permission.ADMINISTRATOR)) {

            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.CYAN);

            var message = event.getMessage();
            try {
                var s = message.getContentRaw().split(" ");
                var memberToBan = message.getMentionedMembers().get(0).getUser();

                event.getGuild().ban(memberToBan, 0,s[2]).complete();
                eb.setDescription(memberToBan.getAsTag() + " has been banned for " + s[2]);
                event.getChannel().sendMessageEmbeds(eb.build()).queue();


                eb.setDescription("You have been banned from " + event.getGuild().getName() + " for " + s[2]);
                memberToBan.openPrivateChannel()
                        .flatMap(privateChannel -> privateChannel.sendMessage(eb.build()))
                        .queue();

            }catch (InsufficientPermissionException exception) {
                eb.setDescription("Not enough permissions to ban a User!");
                message.replyEmbeds(eb.build()).queue();
            }catch (HierarchyException exception) {
                eb.setDescription("The user to be banned has higher roles than me, Cant ban");
                message.replyEmbeds(eb.build()).queue();
            }catch (IndexOutOfBoundsException exception) {
                eb.setTitle("Not Correct Format!");
                eb.setDescription(
                        """
                        Correct format:
                        """ + Main.prefix +
                        """
                        ban @user reason
                        Example - ban @Momin for being too cool :sunglasses:\040
                        """);
                event.getChannel().sendMessage(eb.build()).queue();
            }catch (Exception exception) {
                eb.setDescription(exception.getMessage());
                message.replyEmbeds(eb.build()).queue();
                exception.printStackTrace();
            }
        }
    }
}
