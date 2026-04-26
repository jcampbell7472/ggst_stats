package io.github.jcampbell7472.ggst_stats.bot;

import java.awt.Color;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Assets {

    public static final Map<String, String> CHARACTER_URLS = Map.ofEntries(
        Map.entry("AN", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401059780395129/anji.png.png?ex=69c901af&is=69c7b02f&hm=0562bad7918fe84ee2ced89fdb9a2cc76e68159b489cec18b6a40385310fafb7&"),
        Map.entry("AX", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401064385876119/axl.png.png?ex=69c901b0&is=69c7b030&hm=f41d393d5c1930c7bc2ff2afd5f8f51d21d4d46478814134f84b94a348eb5984&"),
        Map.entry("LE", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401067707895929/leo.png.png?ex=69c901b1&is=69c7b031&hm=09e9ea7e16422ff8ca2f7d2deb5b0619b3c4cac88b4cb2c3755af0517aa5ca6a&"),
        Map.entry("MI", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401070094192761/millia.png.png?ex=69c901b1&is=69c7b031&hm=6340b96c76e30dce17235d9c58f7ac0f7e7d7a44519fe4df77eee8251a1de0e7&"),
        Map.entry("GO", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401074540150845/goldlewis.png.png?ex=69c901b2&is=69c7b032&hm=30e01998e4421c218f647cb654afc8926ecbafd98e51269d07cd40f7b666db5f&"),
        Map.entry("BE", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401079594418298/bedman.png.png?ex=69c901b3&is=69c7b033&hm=898b2928441d1cea0f41f0775a3bab082d441c2a70e595d89f6dfa995fa729b0&"),
        Map.entry("SL", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401082849333399/slayer.png.png?ex=69c901b4&is=69c7b034&hm=dd8d0fab04cc5071a31963b543256878d47236f60c23d688870e94234aa5dc4f&"),
        Map.entry("SI", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401086540320768/sin.png.png?ex=69c901b5&is=69c7b035&hm=f2e7a47f143d6bf63dd9f3493b7b6bec15e5b9a8bf70658f6247dbb99c784c3d&"),
        Map.entry("TE", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401090889547877/testament.png.png?ex=69c901b6&is=69c7b036&hm=63cc7ac65f98b9e5b16b90a0aa60b5717a8f53904aea87d6b14455edb050f511&"),
        Map.entry("UN", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401093943005365/unika.png.png?ex=69c901b7&is=69c7b037&hm=b7e0d6919e34b9218bef05a68b0c931c1046f0b1827cf1c27b5df17311c84188&"),
        Map.entry("CH", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401102751039558/chipp.png.png?ex=69c901b9&is=69c7b039&hm=8abb0e7cb04d32a9d86d89779a0e195113c9fb4c6e0be279e888a346b8619b3a&"),
        Map.entry("ZA", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401105888641064/zato.png.png?ex=69c901ba&is=69c7b03a&hm=42f2b767d2b6a81ed5bc385e7aa44ab94b86c19176aa3c5fce4e12912f095d95&"),
        Map.entry("PO", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401111034793994/potemkin.png.png?ex=69c901bb&is=69c7b03b&hm=136be41addcf0091f8d66d0f2f5637960486ff6ba85263963809cf120a42ca63&"),
        Map.entry("EL", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401114738491502/elphelt.png.png?ex=69c901bc&is=69c7b03c&hm=65c5b2428342380eb3f492b754c43a8b806a7f2c55c71eafeb535d6562a99410&"),
        Map.entry("BA", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401118425153546/baiken.png.png?ex=69c901bd&is=69c7b03d&hm=5926399da32d7f076a1558d25905f72809c3917e1bc81e916121b1a95fab50cc&"),
        Map.entry("LU", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401120665174036/lucy.png.png?ex=69c901bd&is=69c7b03d&hm=b0a5d931edeb75b4aaf4455bc5627527422f90bcd90cd173b469afd288314666&"),
        Map.entry("AB", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401125429772499/aba.png.png?ex=69c901be&is=69c7b03e&hm=76333f3158d2f59e992104fe8888c0d7a861eaa5bf5bc858cd263388bca5602c&"),
        Map.entry("JN", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401128923496528/johnny.png.png?ex=69c901bf&is=69c7b03f&hm=9cc70fbafff550270fd969153f0d67d54d08be750a09b3d6cfee8602d5612047&"),
        Map.entry("IN", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401133709332611/ino.png.png?ex=69c901c0&is=69c7b040&hm=4c5982bc6b0ee945c2e0d3f4ff1bb8d9c77f8cb084a8a923daed59a4eb5e5bc5&"),
        Map.entry("NA", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401137366761573/nagoriyuki.png.png?ex=69c901c1&is=69c7b041&hm=08638a4b604eaad85f489c63c192c0a89ef92e874650acf482084646d9ec6483&"),
        Map.entry("KY", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401142601125909/ky.png.png?ex=69c901c2&is=69c7b042&hm=f64852e038d070ec326b0a592d17935b0fc86ed386f0ee7b0d63991ea04575a6&"),
        Map.entry("HA", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401147110265052/happychaos.png.png?ex=69c901c4&is=69c7b044&hm=ca81b69ba3dd5709be32ac2243661f137c1537baa47236819512d4cd35a6f9e1&"),
        Map.entry("MA", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401150528360550/may.png.png?ex=69c901c4&is=69c7b044&hm=6f1cba8f7d6a7b06a95bb6d2e5da107822565b8d5acc5b7a9b6120650d1c913a&"),
        Map.entry("JC", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401154072805396/jacko.png.png?ex=69c901c5&is=69c7b045&hm=2c360b13a7ef0398676b79d3e3f0cf529bf837ce6d4463c1721fb8e162d74ff4&"),
        Map.entry("SO", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401158908842066/sol.png.png?ex=69c901c6&is=69c7b046&hm=78835f716bc26de78f1c07d634d50a8fbb20f87a216c710343a3987f006b5d27&"),
        Map.entry("DI", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401164457639966/dizzy.png.png?ex=69c901c8&is=69c7b048&hm=5d63d7ace70cb55e3ce04f037c93def2bb30dfa0ea1bb92246cd8eb12a81c384&"),
        Map.entry("FA", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401167498510516/faust.png.png?ex=69c901c8&is=69c7b048&hm=b9ea64fb6b3e0f3cfc082150e40af223e6e8e19b5b44b65f539eadc610403394&"),
        Map.entry("RA", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401170325606531/ramlethal.png.png?ex=69c901c9&is=69c7b049&hm=f49d99cac27008afd86976c5d055487ad3523362b6e3db74d8a5f97a9252bca6&"),
        Map.entry("AS", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401176004563024/asuka.png.png?ex=69c901ca&is=69c7b04a&hm=b7e0d6919e34b9218bef05a68b0c931c1046f0b1827cf1c27b5df17311c84188&"),
        Map.entry("GI", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401179511263272/giovanna.png.png?ex=69c901cb&is=69c7b04b&hm=2c360b13a7ef0398676b79d3e3f0cf529bf837ce6d4463c1721fb8e162d74ff4&"),
        Map.entry("VE", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401184447696976/venom.png.png?ex=69c901cc&is=69c7b04c&hm=8321e24dea41eaba4d54af6a1e9d7c9c221b7b34fc2be691695df42a17793f6a&"),
        Map.entry("BI", "https://cdn.discordapp.com/attachments/1487399812650238094/1487401188227026964/bridget.png.png?ex=69c901cd&is=69c7b04d&hm=3cf902a4c3d076a9e58462f8da9eafab6c3e89bc2443a28863db0a5d3b46edc7&"),
        Map.entry("JA", "https://cdn.discordapp.com/attachments/1487399812650238094/1497817711554859149/jam.png?ex=69eee6f2&is=69ed9572&hm=d404f279320cefb55290b9c1d8d8a53c607a9ca70598c7a3dbdf86fb3cc0cfcc")
    );

    public static final Map<String, String> RANK_URLS = Map.ofEntries(
        Map.entry("Placement",   "https://cdn.discordapp.com/attachments/1487399812650238094/1487401190043156543/placement.png.png?ex=69c901ce&is=69c7b04e&hm=e4239c5583bc4f12398be3c89fdbfb509c85c3008af202c4fb84172d140f5259&"),
        Map.entry("Iron 1",      "https://cdn.discordapp.com/attachments/1487399812650238094/1487401191662157854/iron1.png.png?ex=69c901ce&is=69c7b04e&hm=0a8fbb64862957f7ec7c8c6c3c89126864ae7716019935dfea4390987a59d792&"),
        Map.entry("Iron 2",      "https://cdn.discordapp.com/attachments/1487399812650238094/1487401193314586674/iron2.png.png?ex=69c901cf&is=69c7b04f&hm=3f92a9013f06ce8f194d53740679fe4de2c0d0860f8c02262aba8fe6e70791f0&"),
        Map.entry("Iron 3",      "https://cdn.discordapp.com/attachments/1487399812650238094/1487401195265065110/iron3.png.png?ex=69c901cf&is=69c7b04f&hm=17608dd1a32ec982abca48dba6923fdf0734c0f6d0705d5612933bb60cd50a45&"),
        Map.entry("Bronze 1",    "https://cdn.discordapp.com/attachments/1487399812650238094/1487401196762173562/bronze1.png.png?ex=69c901cf&is=69c7b04f&hm=30e218077c37dcd83c723340f476156a7644c484963ded7025d23c9a2f4fa4ed&"),
        Map.entry("Bronze 2",    "https://cdn.discordapp.com/attachments/1487399812650238094/1487401215955439696/bronze2.png.png?ex=69c901d4&is=69c7b054&hm=76394bfb1cb9c0757e0bda115ebe95e903fb8031b18b445aa2bd5768a8b5984&"),
        Map.entry("Bronze 3",    "https://cdn.discordapp.com/attachments/1487399812650238094/1487401218270826556/bronze3.png.png?ex=69c901d5&is=69c7b055&hm=d168e09e9f1dea26eec838d5ec78bdec5b24ee1e468a3a4ebd85e52ccdb3b00d&"),
        Map.entry("Silver 1",    "https://cdn.discordapp.com/attachments/1487399812650238094/1487401219793092618/silver1.png.png?ex=69c901d5&is=69c7b055&hm=1f1e36f2dae8e79ead7e4b572042329a68dbb271d5d53408f5a7bc20b565ed57&"),
        Map.entry("Silver 2",    "https://cdn.discordapp.com/attachments/1487399812650238094/1487401223245135924/silver2.png.png?ex=69c901d6&is=69c7b056&hm=d6f07f8f3018538ff5c1e942b152e6efc4d46c2b531d753c4dbd1e8514a6d773&"),
        Map.entry("Silver 3",    "https://cdn.discordapp.com/attachments/1487399812650238094/1487401225254080656/silver3.png.png?ex=69c901d6&is=69c7b056&hm=b9ea64fb6b3e0f3cfc082150e40af223e6e8e19b5b44b65f539eadc610403394&"),
        Map.entry("Gold 1",      "https://cdn.discordapp.com/attachments/1487399812650238094/1487401227879714916/gold1.png.png?ex=69c901d7&is=69c7b057&hm=5fbd53ab6f77f0c8434bc1cfe0bae19fb8ea8485f49988a0e16a709710162c0c&"),
        Map.entry("Gold 2",      "https://cdn.discordapp.com/attachments/1487399812650238094/1487401229536460861/gold2.png.png?ex=69c901d7&is=69c7b057&hm=92a10bfdb8e056ff074fba5470bf15418c6407235d6dbca724184a7b5a42b70d&"),
        Map.entry("Gold 3",      "https://cdn.discordapp.com/attachments/1487399812650238094/1487401231315112016/gold3.png.png?ex=69c901d8&is=69c7b058&hm=0e9aa64784c5bc7acb997982b0225fef68cc262c5b6858705fbf45e0a52cbf80&"),
        Map.entry("Platinum 1",  "https://cdn.discordapp.com/attachments/1487399812650238094/1487401250696724520/platinum1.png.png?ex=69c901dc&is=69c7b05c&hm=6a11d3d967e3d6e5746a9a621e54ee370938f1ec0437271ec93e14a473700188&"),
        Map.entry("Platinum 2",  "https://cdn.discordapp.com/attachments/1487399812650238094/1487401253519626361/platinum2.png.png?ex=69c901dd&is=69c7b05d&hm=a478b0a8cfbf46ccb41f33d64cfeb857bd3423c6268dad9d6fb79dc77e80cc4a&"),
        Map.entry("Platinum 3",  "https://cdn.discordapp.com/attachments/1487399812650238094/1487401255847596104/platinum3.png.png?ex=69c901dd&is=69c7b05d&hm=9792204376cca5f994489c3921845d8c48dbcfb532e391b567f0c7404365019e&"),
        Map.entry("Diamond 1",   "https://cdn.discordapp.com/attachments/1487399812650238094/1487401257881833678/diamond1.png.png?ex=69c901de&is=69c7b05e&hm=115431a9f32d6fabfdaea5df6ab8091bded18a8b15b66bd802dee387468a6af4&"),
        Map.entry("Diamond 2",   "https://cdn.discordapp.com/attachments/1487399812650238094/1487401260142297208/diamond2.png.png?ex=69c901de&is=69c7b05e&hm=2750b6c3c6487be9c78cf2b83dc19a6529504f6b6aa53d788783c00150c23f14&"),
        Map.entry("Diamond 3",   "https://cdn.discordapp.com/attachments/1487399812650238094/1487401262579191909/diamond3.png.png?ex=69c901df&is=69c7b05f&hm=6203cb3bee99bb8b37e6fe9a8527ccb97b722482e934f581e1e50f5b82b2fe13&"),
        Map.entry("Vanquisher",  "https://cdn.discordapp.com/attachments/1487399812650238094/1487401265238376642/vanquisher.png.png?ex=69c901e0&is=69c7b060&hm=222d286517b8f077c1798f342c7321d53eaa4e3e58593d75856afc1ec0a2693d&"),
        Map.entry("Vanquisher I Ignis","https://cdn.discordapp.com/attachments/1487399812650238094/1497832081122791544/vanquisher1.png?ex=69eef454&is=69eda2d4&hm=7db39077c5dd5f9a3e4e42048112d229fc5692a12762283c9436ef649f7639ce"),
        Map.entry("Vanquisher II Virtus","https://cdn.discordapp.com/attachments/1487399812650238094/1497832110281457664/vanquisher2.png?ex=69eef45b&is=69eda2db&hm=2cd4b77ac614e1947b8da3a0f0d841f08abb020ab9d244fef504c512ed689f3d"),
        Map.entry("Vanquisher III Vindex","https://cdn.discordapp.com/attachments/1487399812650238094/1497832135413993502/vanquisher3.png?ex=69eef461&is=69eda2e1&hm=15769072bf25dff2371679c2c0cad90097f2cecfffd48effdfd1d135c41be8cc"),
        Map.entry("Imperius","https://cdn.discordapp.com/attachments/1487399812650238094/1497832160919425136/vanquisher4.png?ex=69eef467&is=69eda2e7&hm=138dd5620fe9742ae645ba1aaa50ab419d36a86d0a8d1722b9d086d4f96ef0ff")
    );

    private static final Map<String, Color> RANK_COLORS = Map.of(
        "Diamond",    Color.CYAN,
        "Platinum",   Color.GREEN,
        "Gold",       Color.YELLOW,
        "Silver",     Color.LIGHT_GRAY,
        "Bronze",     new Color(205, 127, 50),
        "Iron",       Color.DARK_GRAY,
        "Vanquisher", Color.MAGENTA
    );

    public static Color getRankColor(String rank) {
        if (rank == null) {
            return Color.GRAY;
        }

        return RANK_COLORS.entrySet().stream()
            .filter(e -> rank.contains(e.getKey()))
            .map(Map.Entry::getValue)
            .findFirst()
            .orElse(Color.WHITE);
    }
}