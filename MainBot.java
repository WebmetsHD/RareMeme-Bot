package me.oreo.bots.mainbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MainBot extends ListenerAdapter {

	public static JDA api;
	public static void main(String[] args) {
		try {
			if(Ref.isBOT) {
				JDA api = new JDABuilder(AccountType.BOT).setToken(Ref.TOKEN).addEventListener(new NextLaunches()).buildBlocking();
				String msg = "Servers: " + api.getGuilds().size();
				String msg2 = "Use !-help";
				api.getPresence().setGame(Game.of(msg + " | " + msg2));
				api.addEventListener(new Commands());
			} else {
				JDA api = new JDABuilder(AccountType.CLIENT).setToken(Ref.TOKEN).addEventListener(new NextLaunches()).buildBlocking();
				String msg = "Servers: " + api.getGuilds().size();
				String msg2 = "Use !-help";
				api.getPresence().setGame(Game.of(msg + " | " + msg2));
			}
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			e.printStackTrace();
		}
	}

}
