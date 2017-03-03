
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.Callable;

public class Bot implements Callable<Bot> {
	
	public static Random rand = new Random();
	
	private Socket socket;
	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;
	private String nick;
	private String oauth;
	
	public Bot(String nick, String oauth) throws Throwable {
		this.nick = nick;
		this.oauth = oauth;
	}

	@Override
	public Bot call() throws Exception  {
		
		socket = new Socket(InetAddress.getByName(Main.IP), Main.PORT);
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		bufferedWriter.write("PASS " + oauth + "\r\n");
		bufferedWriter.write("NICK " + nick + "\r\n");
		bufferedWriter.flush();
		String line = "#TBO";
		while((line = bufferedReader.readLine()) != null) {
			if (line.contains("Welcome, GLHF")) {
				System.out.println("[!] " + nick + " logged in.");
				break;
			}
		}
		
		bufferedWriter.write("JOIN " + Main.CHANNEL + "\r\n");
		bufferedWriter.flush();
		while((line = bufferedReader.readLine()) != null) {
			if (line.contains(":End of /NAMES lis")) {
				System.out.println("[+] " + nick + " joined " + Main.CHANNEL + ".");
				break;
			}
		}
		
		
		int i = 0;
		while(i==0) {
			bufferedWriter.write("PRIVMSG " + Main.CHANNEL + " :" + Util.generateSpamMessage() + "\r\n");
			bufferedWriter.flush();
			Thread.sleep((5000 + rand.nextInt(6000 - 5000 + 1)));
		}
		
		return null;
		
	}
	
}
