
import java.util.Random;

public class Util {
	public static final String[] FREE_EMOTES = {
			"4Head", "AMPEnergy", "AMPEnergyCherry", "AMPTropPunch", "ANELE", "ArgieB8",
			"ArsonNoSexy", "AsianGlow", "BabyRage", "BatChest", "BCouch", "BCWarrior",
			"BibleThump", "BigBrother", "BlargNaut", "bleedPurple", "BlessRNG", "BloodTrail",
			"BrainSlug", "BrokeBack", "BudBlast", "BuddhaBar", "BudStar", "ChefFrank",
			"cmonBruh", "CoolCat", "CoolStoryBob", "copyThis", "CorgiDerp", "CurseLit",
			"DAESuppy", "DansGame", "DatSheffy", "DBstyle", "DendiFace", "DogFace",
			"DoritosChip", "duDudu", "DxAbomb", "DxCat", "EagleEye", "EleGiggle",
			"FailFish", "FrankerZ", "FreakinStinkin", "FUNgineer", "FunRun", "FutureMan",
			"GingerPower", "GivePLZ", "GOWSkull", "GrammarKing", "HassaanChop", "HassanChop",
			"HeyGuys", "HotPokket", "HumbleLife", "imGlitch", "ItsBoshyTime", "Jebaited",
			"JKanStyle", "JonCarnage", "KAPOW", "Kappa", "KappaClaus", "KappaPride",
			"KappaRoss", "KappaWealth", "Keepo", "KevinTurtle", "Kippa", "Kreygasm",
			"Mau5", "mcaT", "MikeHogu", "MingLee", "MrDestructoid", "MVGame",
			"NerfBlueBlaster", "NerdRedBlaster", "NinjaGrumpy", "NomNom", "NotATK", "NotLikeThis",
			"OhMyDog", "OneHand", "OpieOP", "OptimizePrime", "OSfrog", "OSkomodo",
			"OSsloth", "panicBasket", "PanicVis", "PartyTime", "pastaThat", "PJSalt",
			"PJSugar", "PMSTwin", "PogChamp", "Poooound", "PraiseIt", "PRChase",
			"PrimeMe", "PunchTrees", "RaccAttack", "RalpherZ", "RedCoat", "ResidentSleeper",
			"riPepperonis", "RitzMitz", "RlyTho", "RuleFive", "SeemsGood", "ShadyLulu",
			"ShazBotstix", "SmoocherZ", "SMOrc", "SoBayed", "SoonerLater", "SSSsss",
			"TBAngel", "TBCheesePull", "TBTacoLeft", "TBTacoRight", "TF2John", "TheIlluminati",
			"TheRinger", "TheTarFu", "TheThing", "ThunBeast", "TinyFace", "TooSpicy",
			"TriHard", "TTours", "twitchRaid", "TwitchRPG", "UncleNox", "UnSane",
			"UWot", "VoHiYo", "VoteNay", "VoteYea", "WholeWheat", "WTRuck",
			"WutFace", "YouDontSay", "YouWHY"
	};
	public static String getRandomFreeEmote() {
		return FREE_EMOTES[new Random().nextInt(FREE_EMOTES.length)];
	}
	public static String getRandomASCII(int len) {
		if (len < 1 || len > 20) return "#TBO";
		
		char arr[] = new char[len];
		Random rand = new Random();
		for (int i=0; i<len; i++) {
			arr[i] = (char)(33 + rand.nextInt(90 - 33 + 1));
		}
		return new String(arr);
	}
	public static String generateSpamMessage() {
		StringBuffer sb = new StringBuffer();
		sb.append(getRandomFreeEmote());
		sb.append(" " + getRandomASCII(5) + " ___ ");
		sb.append(Main.MSG);
		sb.append(" ___ " + getRandomASCII(5) + " ");
		sb.append(getRandomFreeEmote());
		return sb.toString();
	}
}
