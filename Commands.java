package me.oreo.bots.mainbot;

import java.awt.Color;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

	@Override
	public void onReady(ReadyEvent event) {
		System.out.println("[UCPlugin] JDA is ready! Bot should be online.");
	}

	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot())
			return;

		event.getJDA();
		event.getResponseNumber();

		User author = event.getAuthor();
		Message message = event.getMessage();
		event.getChannel();

		String msg = message.getContent();

		author.isBot();

		if (event.isFromType(ChannelType.TEXT)) {
			Guild guild = event.getGuild();
			TextChannel textChannel = event.getTextChannel();
			Member member = event.getMember();

			String name;
			if (message.isWebhookMessage()) {
				name = author.getName();
			} else {
				name = member.getEffectiveName();
			}

			System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(), textChannel.getName(), name, msg);
		} else if (event.isFromType(ChannelType.PRIVATE)) {
			event.getPrivateChannel();

			System.out.printf("[PRIV]<%s>: %s\n", author.getName(), msg);
		} else if (event.isFromType(ChannelType.GROUP)) {
			Group group = event.getGroup();
			String groupName = group.getName();

			System.out.printf("[GRP: %s]<%s>: %s\n", groupName, author.getName(), msg);
		}
	}

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] command = event.getMessage().getContent().split(" ");
		String message = event.getMessage().getContent();

		if (!command[0].startsWith(Ref.PREFIX))
			return;
		if (command[0].equalsIgnoreCase("!-help")) {

			String msg = ":game_die: Made by Eliza :game_die:" 
					+ "\n\n\n\n" 
					+ "                 !-help" 
					+ "\n\n"
					+ "                 !-ping" 
					+ "\n\n" 
					+ "                 !-info";

			if (command.length == 1) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setColor(Color.CYAN);
				eb.setDescription(msg);

				MessageEmbed newmsg = eb.build();
				sendPrivateMessage(event.getAuthor(), newmsg);
			}

			String msgver2 = ":100: Help sent privatly! :100:";

			if (command.length == 1) {
				EmbedBuilder eb = new EmbedBuilder();

				eb.setFooter(Constants.EMBED_FOOTER_NAME, Constants.EMBED_FOOTER_IMAGE);
				eb.setColor(Color.green);
				eb.setDescription(msgver2);

				event.getChannel().sendMessage(eb.build()).queue();
			}
		}
		
		if (command[0].equalsIgnoreCase("!-info")) {
			
			String twitter = "https://twitter.com/ZoeyGlobe";
			String discord = "https://discord.gg/nQQmHYj";
			String github = "https://zoeyglobe.github.io";
			String eliza = "https://www.facebook.com/profile.php?id=100013427896915";
			String insta = "https://www.instagram.com/ZoeyGlobe/";
			
			String msg = "Zoey's information:";
			
			if (command.length == 1) {
				
				EmbedBuilder eb = new EmbedBuilder();
				eb.setFooter(Constants.EMBED_FOOTER_NAME, Constants.EMBED_FOOTER_IMAGE);
				eb.setTitle(msg);
				eb.setColor(Color.RED);
				eb.addField("Her discord", "[Discord]" + "(" + discord + ")", true);
				eb.addField("Her twitter", "[Twitter]" + "(" + twitter + ")", true);
				eb.addField("Her Website", "[Website]" + "(" + github + ")", true);
				eb.addField("Her Instagram", "[Instagram]" + "(" + insta + ")", true);
				eb.addField("Bot Developer", "[Eliza]" + "(" + eliza + ")", true);
				
				event.getChannel().sendMessage(eb.build()).queue();
				}
			}

		if (command[0].equalsIgnoreCase("!-ping")) {

			String msg = ":alarm_clock: Reply time: :alarm_clock:\n                 " + event.getJDA().getPing();
			
			if (command.length == 1) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setColor(Color.PINK);
				eb.setDescription(msg);
				eb.setFooter(Constants.EMBED_FOOTER_NAME, Constants.EMBED_FOOTER_IMAGE);
				
				event.getChannel().sendMessage(eb.build()).queue();
			}
		}
		
		if (command[0].equalsIgnoreCase("!-joke)) {
		     		EmbedBuilder eb = new EmbedBuilder();
				Random rand = new Random();
						
				String jokes[] = {"Jokes, Jokes, Jokes, Jokes, Jokes Jokes"};
						
			event.getChannel().sendMessage(jokes).queue();		
			}
	}


	public void sendPrivateMessage(User user, MessageEmbed newmsg) {
		// openPrivateChannel provides a RestAction<PrivateChannel>
		// which means it supplies you with the resulting channel
		user.openPrivateChannel().queue((channel) -> {
			channel.sendMessage(newmsg).queue();
		});
	}

	public void newPrivateMessage(User user, String conten) {

		user.openPrivateChannel().queue((channel) -> {
			channel.sendMessage(conten).queue();
		});
	}

}
