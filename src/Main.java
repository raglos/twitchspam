
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;

public class Main {
	
	public static final String IP = "irc.chat.twitch.tv";
	public static final int PORT = 6667;
	public static final String CHANNEL = "#twitchusername";
	public static final String MSG = "generic spam message";
	
	static ExecutorService exe = Executors.newCachedThreadPool();
	static List<Callable<Bot>> bots = new ArrayList<>();
	
	public static void main(String args[]) throws Throwable {
		
		// get oauth from https://twitchapps.com/tmi/
		// bots get banned really fast sometimes :(
		bots.add(new Bot("twitchusername1", "oauth:sai511esdfdmu3d7sdddhqvc8ssfkj"));
		bots.add(new Bot("twitchusername2", "oauth:jb9c8kd4s4wsdfsdffg4rd5zd02dac"));
		// ... 
		exe.invokeAll(bots);
	}
}
