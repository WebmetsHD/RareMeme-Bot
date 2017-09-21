package me.oreo.bots.mainbot;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class NextLaunches extends ListenerAdapter {
	
	public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
    }
	
	
	public void onMessageReceived(MessageReceivedEvent event) {
		String msg = event.getMessage().getContent();
		EmbedBuilder eb = new EmbedBuilder();
		if(msg.equalsIgnoreCase("=>launches") || msg.equalsIgnoreCase("=>launches 1")) {
			try {
		        JSONObject json = new JSONObject(getText("https://launchlibrary.net/1.2/launch/next/10"));
		        JSONArray jsonArray = json.getJSONArray("launches");
		        	JSONObject launch1 = jsonArray.getJSONObject(0);
			        JSONObject location1 = launch1.getJSONObject("location");
			        JSONArray pads1 = location1.getJSONArray("pads");
			        JSONObject pad1 = pads1.getJSONObject(0);
			        JSONObject rocket1 = launch1.getJSONObject("rocket");
			        JSONArray missions1 = launch1.getJSONArray("missions");
			        JSONObject mission1 = missions1.getJSONObject(0);
			        eb.addField(launch1.getString("name"), "[" + pad1.getString("name") + "](" + pad1.getString("mapURL") +")\nUse `=>launch " + launch1.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission1.getString("name") + "**\n" + mission1.getString("description") + "\n`Type: " + mission1.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket1.getString("name") + "**\nFamily Name: " + rocket1.getString("familyname") + "\nConfiguration: " + rocket1.getString("configuration"), false);
			        eb.addBlankField(false);
			        
			        JSONObject launch2 = jsonArray.getJSONObject(1);
			        JSONObject location2 = launch2.getJSONObject("location");
			        JSONArray pads2 = location2.getJSONArray("pads");
			        JSONObject pad2 = pads2.getJSONObject(0);
			        JSONObject rocket2 = launch2.getJSONObject("rocket");
			        JSONArray missions2 = launch2.getJSONArray("missions");
			        JSONObject mission2 = missions2.getJSONObject(0);
			        eb.addField(launch2.getString("name"), "[" + pad2.getString("name") + "](" + pad2.getString("mapURL") +")\nUse `=>launch " + launch2.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission2.getString("name") + "**\n" + mission2.getString("description") + "\n`Type: " + mission2.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket2.getString("name") + "**\nFamily Name: " + rocket2.getString("familyname") + "\nConfiguration: " + rocket2.getString("configuration"), false);
 
		        eb.setTitle("Launches [Page 1/5]", "https://launchlibrary.net/");
		        eb.setDescription("Use `=>launches [1-5]` for more launches.");
		        eb.setColor(Color.CYAN);
		        event.getChannel().sendMessage(eb.build()).queue();
		    }catch (Exception ex) {
		        eb.setColor(Color.red);
		        eb.setTitle("Please send the following message to the developers", "https://launchlibrary.net/");
		        eb.setDescription(ex.getMessage());
		        event.getChannel().sendMessage(eb.build()).queue();
		        ex.printStackTrace();
		    }
		}
		if(msg.equalsIgnoreCase("=>launches 2")) {
			try {
		        JSONObject json = new JSONObject(getText("https://launchlibrary.net/1.2/launch/next/10"));
		        JSONArray jsonArray = json.getJSONArray("launches");
		        	JSONObject launch1 = jsonArray.getJSONObject(2);
			        JSONObject location1 = launch1.getJSONObject("location");
			        JSONArray pads1 = location1.getJSONArray("pads");
			        JSONObject pad1 = pads1.getJSONObject(0);
			        JSONObject rocket1 = launch1.getJSONObject("rocket");
			        JSONArray missions1 = launch1.getJSONArray("missions");
			        JSONObject mission1 = missions1.getJSONObject(0);
			        eb.addField(launch1.getString("name"), "[" + pad1.getString("name") + "](" + pad1.getString("mapURL") +")\nUse `=>launch " + launch1.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission1.getString("name") + "**\n" + mission1.getString("description") + "\n`Type: " + mission1.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket1.getString("name") + "**\nFamily Name: " + rocket1.getString("familyname") + "\nConfiguration: " + rocket1.getString("configuration"), false);
			        eb.addBlankField(false);
			        
			        JSONObject launch2 = jsonArray.getJSONObject(3);
			        JSONObject location2 = launch2.getJSONObject("location");
			        JSONArray pads2 = location2.getJSONArray("pads");
			        JSONObject pad2 = pads2.getJSONObject(0);
			        JSONObject rocket2 = launch2.getJSONObject("rocket");
			        JSONArray missions2 = launch2.getJSONArray("missions");
			        JSONObject mission2 = missions2.getJSONObject(0);
			        eb.addField(launch2.getString("name"), "[" + pad2.getString("name") + "](" + pad2.getString("mapURL") +")\nUse `=>launch " + launch2.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission2.getString("name") + "**\n" + mission2.getString("description") + "\n`Type: " + mission2.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket2.getString("name") + "**\nFamily Name: " + rocket2.getString("familyname") + "\nConfiguration: " + rocket2.getString("configuration"), false);
 
		        eb.setTitle("Launches [Page 2/5]", "https://launchlibrary.net/");
		        eb.setDescription("Use `=>launches [1-5]` for more launches.");
		        eb.setColor(Color.CYAN);
		        event.getChannel().sendMessage(eb.build()).queue();
		    }catch (Exception ex) {
		        eb.setColor(Color.red);
		        eb.setTitle("Please send the following message to the developers", "https://launchlibrary.net/");
		        eb.setDescription(ex.getMessage());
		        event.getChannel().sendMessage(eb.build()).queue();
		        ex.printStackTrace();
		    }
		}
		if(msg.equalsIgnoreCase("=>launches 3")) {
			try {
		        JSONObject json = new JSONObject(getText("https://launchlibrary.net/1.2/launch/next/10"));
		        JSONArray jsonArray = json.getJSONArray("launches");
		        	JSONObject launch1 = jsonArray.getJSONObject(4);
			        JSONObject location1 = launch1.getJSONObject("location");
			        JSONArray pads1 = location1.getJSONArray("pads");
			        JSONObject pad1 = pads1.getJSONObject(0);
			        JSONObject rocket1 = launch1.getJSONObject("rocket");
			        JSONArray missions1 = launch1.getJSONArray("missions");
			        JSONObject mission1 = missions1.getJSONObject(0);
			        eb.addField(launch1.getString("name"), "[" + pad1.getString("name") + "](" + pad1.getString("mapURL") +")\nUse `=>launch " + launch1.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission1.getString("name") + "**\n" + mission1.getString("description") + "\n`Type: " + mission1.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket1.getString("name") + "**\nFamily Name: " + rocket1.getString("familyname") + "\nConfiguration: " + rocket1.getString("configuration"), false);
			        eb.addBlankField(false);
			        
			        JSONObject launch2 = jsonArray.getJSONObject(5);
			        JSONObject location2 = launch2.getJSONObject("location");
			        JSONArray pads2 = location2.getJSONArray("pads");
			        JSONObject pad2 = pads2.getJSONObject(0);
			        JSONObject rocket2 = launch2.getJSONObject("rocket");
			        JSONArray missions2 = launch2.getJSONArray("missions");
			        JSONObject mission2 = missions2.getJSONObject(0);
			        eb.addField(launch2.getString("name"), "[" + pad2.getString("name") + "](" + pad2.getString("mapURL") +")\nUse `=>launch " + launch2.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission2.getString("name") + "**\n" + mission2.getString("description") + "\n`Type: " + mission2.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket2.getString("name") + "**\nFamily Name: " + rocket2.getString("familyname") + "\nConfiguration: " + rocket2.getString("configuration"), false);
 
		        eb.setTitle("Launches [Page 3/5]", "https://launchlibrary.net/");
		        eb.setDescription("Use `=>launches [1-5]` for more launches.");
		        eb.setColor(Color.CYAN);
		        event.getChannel().sendMessage(eb.build()).queue();
		    }catch (Exception ex) {
		        eb.setColor(Color.red);
		        eb.setTitle("Please send the following message to the developers", "https://launchlibrary.net/");
		        eb.setDescription(ex.getMessage());
		        event.getChannel().sendMessage(eb.build()).queue();
		        ex.printStackTrace();
		    }
		}
		if(msg.equalsIgnoreCase("=>launches 4")) {
			try {
		        JSONObject json = new JSONObject(getText("https://launchlibrary.net/1.2/launch/next/10"));
		        JSONArray jsonArray = json.getJSONArray("launches");
		        	JSONObject launch1 = jsonArray.getJSONObject(6);
			        JSONObject location1 = launch1.getJSONObject("location");
			        JSONArray pads1 = location1.getJSONArray("pads");
			        JSONObject pad1 = pads1.getJSONObject(0);
			        JSONObject rocket1 = launch1.getJSONObject("rocket");
			        JSONArray missions1 = launch1.getJSONArray("missions");
			        JSONObject mission1 = missions1.getJSONObject(0);
			        eb.addField(launch1.getString("name"), "[" + pad1.getString("name") + "](" + pad1.getString("mapURL") +")\nUse `=>launch " + launch1.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission1.getString("name") + "**\n" + mission1.getString("description") + "\n`Type: " + mission1.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket1.getString("name") + "**\nFamily Name: " + rocket1.getString("familyname") + "\nConfiguration: " + rocket1.getString("configuration"), false);
			        eb.addBlankField(false);
			        
			        JSONObject launch2 = jsonArray.getJSONObject(7);
			        JSONObject location2 = launch2.getJSONObject("location");
			        JSONArray pads2 = location2.getJSONArray("pads");
			        JSONObject pad2 = pads2.getJSONObject(0);
			        JSONObject rocket2 = launch2.getJSONObject("rocket");
			        JSONArray missions2 = launch2.getJSONArray("missions");
			        JSONObject mission2 = missions2.getJSONObject(0);
			        eb.addField(launch2.getString("name"), "[" + pad2.getString("name") + "](" + pad2.getString("mapURL") +")\nUse `=>launch " + launch2.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission2.getString("name") + "**\n" + mission2.getString("description") + "\n`Type: " + mission2.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket2.getString("name") + "**\nFamily Name: " + rocket2.getString("familyname") + "\nConfiguration: " + rocket2.getString("configuration"), false);
 
		        eb.setTitle("Launches [Page 4/5]", "https://launchlibrary.net/");
		        eb.setDescription("Use `=>launches [1-5]` for more launches.");
		        eb.setColor(Color.CYAN);
		        event.getChannel().sendMessage(eb.build()).queue();
		    }catch (Exception ex) {
		        eb.setColor(Color.red);
		        eb.setTitle("Please send the following message to the developers", "https://launchlibrary.net/");
		        eb.setDescription(ex.getMessage());
		        event.getChannel().sendMessage(eb.build()).queue();
		        ex.printStackTrace();
		    }
		}
		if(msg.equalsIgnoreCase("=>launches 5")) {
			try {
		        JSONObject json = new JSONObject(getText("https://launchlibrary.net/1.2/launch/next/10"));
		        JSONArray jsonArray = json.getJSONArray("launches");
		        	JSONObject launch1 = jsonArray.getJSONObject(8);
			        JSONObject location1 = launch1.getJSONObject("location");
			        JSONArray pads1 = location1.getJSONArray("pads");
			        JSONObject pad1 = pads1.getJSONObject(0);
			        JSONObject rocket1 = launch1.getJSONObject("rocket");
			        JSONArray missions1 = launch1.getJSONArray("missions");
			        JSONObject mission1 = missions1.getJSONObject(0);
			        eb.addField(launch1.getString("name"), "[" + pad1.getString("name") + "](" + pad1.getString("mapURL") +")\nUse `=>launch " + launch1.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission1.getString("name") + "**\n" + mission1.getString("description") + "\n`Type: " + mission1.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket1.getString("name") + "**\nFamily Name: " + rocket1.getString("familyname") + "\nConfiguration: " + rocket1.getString("configuration"), false);
			        eb.addBlankField(false);
			        
			        JSONObject launch2 = jsonArray.getJSONObject(9);
			        JSONObject location2 = launch2.getJSONObject("location");
			        JSONArray pads2 = location2.getJSONArray("pads");
			        JSONObject pad2 = pads2.getJSONObject(0);
			        JSONObject rocket2 = launch2.getJSONObject("rocket");
			        JSONArray missions2 = launch2.getJSONArray("missions");
			        JSONObject mission2 = missions2.getJSONObject(0);
			        eb.addField(launch2.getString("name"), "[" + pad2.getString("name") + "](" + pad2.getString("mapURL") +")\nUse `=>launch " + launch2.get("id").toString() + "` for more infomation on this launch.", false);
			        eb.addField("Mission", "**" + mission2.getString("name") + "**\n" + mission2.getString("description") + "\n`Type: " + mission2.getString("typeName") + "`", false);
			        eb.addField("Rocket", "**" + rocket2.getString("name") + "**\nFamily Name: " + rocket2.getString("familyname") + "\nConfiguration: " + rocket2.getString("configuration"), false);
 
		        eb.setTitle("Launches [Page 5/5]", "https://launchlibrary.net/");
		        eb.setDescription("Use `=>launches [1-5]` for more launches.");
		        eb.setColor(Color.CYAN);
		        event.getChannel().sendMessage(eb.build()).queue();
		    }catch (Exception ex) {
		        eb.setColor(Color.red);
		        eb.setTitle("Please send the following message to the developers", "https://launchlibrary.net/");
		        eb.setDescription(ex.getMessage());
		        event.getChannel().sendMessage(eb.build()).queue();
		        ex.printStackTrace();
		    }
		}
		if(msg.startsWith("=>launch ")) {
			String id = msg.substring("=>launch ".length());
			JSONObject json;
			try {
				json = new JSONObject(getText("https://launchlibrary.net/1.2/launch/" + id));
				JSONObject launch = json.getJSONArray("launches").getJSONObject(0);
				JSONObject rocket = launch.getJSONObject("rocket");
				JSONObject mission = launch.getJSONArray("missions").getJSONObject(0);
				JSONObject location = launch.getJSONObject("location");
				JSONObject pad = location.getJSONArray("pads").getJSONObject(0);
				JSONObject agency = rocket.getJSONArray("agencies").getJSONObject(0);
				eb.setColor(Color.CYAN);
				eb.setTitle("Launch Information | " + launch.getString("name"), "https://launchlibrary.net/");
				eb.setImage(rocket.getString("imageURL"));
				eb.addField("Agency", "[**" + agency.getString("name") + "**](" + agency.getJSONArray("infoURLs").getString(0) + ")", false);
				eb.addField("Launch Window", "Start: " + launch.getString("windowstart") + "\nEnd: " + launch.getString("windowend"), false);
				eb.addField("Stream Link", launch.getJSONArray("vidURLs").getString(0), false);
				eb.addField("Rocket", "[**" + rocket.getString("name") + "**](" + rocket.getString("wikiURL") + ")\nConfiguration: " + rocket.getString("configuration") + "\nFamily: " + rocket.getString("familyname"), false);
				eb.addField("Mission", "**" + mission.getString("name") + "**\n" + mission.getString("description") + "\n`Type: " + mission.getString("typeName") + "`", false);
				eb.addField("Location", "**" + location.getString("name") + "**\nPad: [" + pad.getString("name") + "](" + pad.getString("wikiURL") + ") | [:map: (Google Maps)](" + pad.getString("mapURL") + ")", false);
				event.getChannel().sendMessage(eb.build()).queue();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
