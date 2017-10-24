package me.oreo.bots.mainbot;

import java.awt.Color;
import java.io.File;
import java.util.List;
import java.util.Random;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
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

	public static JDA api;
	public AudioPlayer player;

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
		@SuppressWarnings("unused")
		String message = event.getMessage().getContent();

		if (command[0].equalsIgnoreCase("!-help")) {

			String space = "                 ";
			String help = "https://raw.githubusercontent.com/WebmetsHD/RareMeme-Bot/master/!-help.txt";
			String ping = "https://raw.githubusercontent.com/WebmetsHD/RareMeme-Bot/master/!-ping.txt";
			String info = "https://raw.githubusercontent.com/WebmetsHD/RareMeme-Bot/master/!-info";
			String error = "https://raw.githubusercontent.com/WebmetsHD/RareMeme-Bot/master/!-error";
			String hug = "https://raw.githubusercontent.com/WebmetsHD/RareMeme-Bot/master/!-hug";

			String msg = ":game_die: Made by Eliza :game_die:" + "\n\n\n\n" + space + "[!-help](" + help + ")" + "\n\n"
					+ space + "[!-ping](" + ping + ")" + "\n\n" + space + "[!-info](" + info + ")" + "\n\n" + space
					+ "[!-error](" + error + ")" + "\n\n" + space + "[!-hug](" + hug + ")" + "\n\n"
					+ "[Bot restarts every 12 hours on average]";

			if (command.length == 1) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setColor(Color.CYAN);
				eb.setDescription(msg);
				eb.setFooter(Constants.EMBED_FOOTER_NAME, null);

				newPrivateMessage(event.getAuthor(), eb.build());
			}

			String msgver2 = ":100: Help sent privately! :100:";

			if (command.length == 1) {
				EmbedBuilder eb = new EmbedBuilder();

				eb.setFooter(Constants.EMBED_FOOTER_NAME, null);
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
			String repo = "https://github.com/WebmetsHD/RareMeme-Bot/tree/master";

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
				eb.addField("Bot repository", "[Repo]" + "(" + repo + ")", true);
				eb.setFooter(Constants.EMBED_FOOTER_NAME, null);

				event.getChannel().sendMessage(eb.build()).queue();
			}
		}

		if (command[0].equalsIgnoreCase("!-ping")) {

			String msg = ":alarm_clock: Reply time: :alarm_clock:\n               " + event.getJDA().getPing() + "ms";

			if (command.length == 1) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setColor(Color.PINK);
				eb.setDescription(msg);
				eb.setFooter(Constants.EMBED_FOOTER_NAME, null);

				event.getChannel().sendMessage(eb.build()).queue();
			}
		}

		if (command[0].equalsIgnoreCase("!-users")) {

			String msg = "Member count:";

			if (command.length == 1) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setColor(Color.MAGENTA);
				eb.addField(msg, "" + event.getGuild().getMembers().size(), true);
				eb.setFooter(Constants.EMBED_FOOTER_NAME, null);

				event.getChannel().sendMessage(eb.build()).queue();
			}
		}

		if (command[0].equalsIgnoreCase("!-error")) {

			String msg = " has been notified!";
			String dev = "<@222997252916903936>";

			EmbedBuilder eb = new EmbedBuilder();

			eb.setColor(Color.RED);
			eb.addField("Notified the developer", dev + msg, true);
			eb.setFooter(Constants.EMBED_FOOTER_NAME, null);

			event.getChannel().sendMessage(eb.build()).queue();
		}

		if (command[0].equalsIgnoreCase("!-debug")) {

			EmbedBuilder eb = new EmbedBuilder();

			eb.setAuthor(Constants.EMBED_AUTHOR, Constants.EMBED_AUTHOR_URL, Constants.EMBED_AUTHOR_IMAGE);
			eb.addField("Guild", event.getGuild().getName(), true);
			eb.addField("Author", "<@222997252916903936>", true);
			eb.addField("Name", "<@359429109316714506>", true);
			eb.addField("ID", "359429109316714506", true);
			eb.addField("Libary", "JDA 3.3.0", true);
			eb.addField("Prefix", "!-", true);
			eb.addField("Upvote Points", "666", true);
			eb.addField("Invite The Bot",
					"[Invite](https://discordapp.com/oauth2/authorize?client_id=359429109316714506&scope=bot&permissions=8)",
					true);
			eb.addField("Short Description",
					"Multi-Purpose Bot with Fun, Moderation, Administrative, Cofiguration and Much More!", false);
			eb.addField("Owners", "<@222997252916903936>\n<@!106128647135444992>", false);
			eb.addField("Links", "Too lazy :)", false);
			eb.setFooter(Constants.EMBED_FOOTER_NAME, null);

			event.getChannel().sendMessage(eb.build()).queue();
		}

		if (command[0].equalsIgnoreCase("!-joke")) {
			Random random = new Random();

			String arr[] = { "Instagram is just Twitter for people who go outside.",
					"I can't believe I made it anywhere creatively, though, because I was raised by two loving and supportive parents. Nothing squashes creativity more than unconditional love and support from a functional household. If you have kids, sh*t on their dreams a little bit.",
					"A husband and wife have four sons. The oldest three are tall with red hair and light skin while the youngest son is short with black hair and dark eyes. The father was on his deathbed when he turned to his wife and said, 'Honey, before I die, be totally honest with me: Is our youngest son my child?' The wife replied, 'I swear on everything that's holy that he is your son.' With that, the husband passed away. The wife muttered, 'Thank God he didn't ask about the other three.'",
					"What's a Jewish mobster? 'I'm going to break the legs of your therapist.'",
					"When you die at 72, no matter what you die of, it's natural causes. Even if you get hit by a truck, its natural causes. Cause if you was younger, you'd got out of the way.",
					"Bill Gates is so rich he hired cancer to kill Steve Jobs." };
			int select = random.nextInt(arr.length);

			event.getChannel().sendMessage(arr[select]).queue();
		}

		if (command[0].startsWith("!-loner")) {
			EmbedBuilder eb = new EmbedBuilder();

			List<User> mentionedUsers = event.getMessage().getMentionedUsers();
			for (User user : mentionedUsers) {
				Member member = event.getGuild().getMember(user);

				eb.setColor(Color.BLUE);
				eb.setDescription("Sorry to tell you, " + member.getAsMention() + ", but you're a loner.");

				event.getChannel().sendMessage(eb.build()).queue();
			}
		}

		if (command[0].startsWith("!-hug")) {
			EmbedBuilder eb = new EmbedBuilder();

			List<User> mentionedUsers = event.getMessage().getMentionedUsers();
			for (User user : mentionedUsers) {
				Member member = event.getGuild().getMember(user);

				if (event.getMessage().isMentioned(event.getAuthor())) {
					event.getChannel().sendMessage("You can't hug yourself, loner.").queue();
				} else {

					// TODO: Replace \ with \\
					String s1 = "C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug.gif";

					String s2 = member.getAsMention() + " you have been hugged by " + event.getAuthor().getAsMention();

					Message s3fin = new MessageBuilder().append(s2).build();

					Random random = new Random();
					String arr[] = { "C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug2.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug3.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug4.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug5.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug6.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Hug7.gif" };
					int select = random.nextInt(arr.length);

					event.getChannel().sendFile(new File(arr[select]), s1, s3fin).queue();
				}
			}
		}
		
		if (command[0].equalsIgnoreCase("faggot")) {
			event.getMessage().delete().complete();
			
			event.getChannel().sendMessage("Please don't be disrespectful.").queue();
		}
		
		if (command[0].startsWith("!-bite")) {
			EmbedBuilder eb = new EmbedBuilder();

			List<User> mentionedUsers = event.getMessage().getMentionedUsers();
			for (User user : mentionedUsers) {
				Member member = event.getGuild().getMember(user);

				if (event.getMessage().isMentioned(event.getAuthor())) {
					event.getChannel().sendMessage("Why are you trying to bite yourself, weirdo.").queue();
				} else {

					// TODO: Replace \ with \\
					String s1 = "C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite.gif";

					String s2 = member.getAsMention() + " you have been bitten by " + event.getAuthor().getAsMention();

					Message s3fin = new MessageBuilder().append(s2).build();

					Random random = new Random();
					String arr[] = { "C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite2.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite3.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite44.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite5.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite6.gif",
							"C:\\Users\\Admin\\Desktop\\EclipsePicsNStuff\\Bite7.gif" };
					int select = random.nextInt(arr.length);

					event.getChannel().sendFile(new File(arr[select]), s1, s3fin).queue();
				}
			}
		}
	}

	public void sendPrivateMessage(User user, String content) {
		// openPrivateChannel provides a RestAction<PrivateChannel>
		// which means it supplies you with the resulting channel
		user.openPrivateChannel().queue((channel) -> {
			channel.sendMessage(content).queue();
		});
	}

	public void newPrivateMessage(User user, MessageEmbed messageEmbed) {

		user.openPrivateChannel().queue((channel) -> {
			channel.sendMessage(messageEmbed).queue();
		});
	}

}
