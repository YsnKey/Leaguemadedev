// Decompiled with: CFR 0.152
// Class Version: 17
package kassuk.addon.blackout.utils.vh;

import com.google.common.primitives.Chars;
import java.util.List;
import meteordevelopment.meteorclient.systems.config.Config;

public enum Fonts {
    DEFAULT("Default", "0123456789abcdefghijklmnopqrstuvwxyz"),
    SMALL_CAPS("Small caps", "0123456789ᴀʙᴄᴅᴇꜰɢʜɪᴊᴋʟᴍɴᴏᴩqʀꜱᴛᴜᴠᴡxʏᴢ"),
    FANCY("Fancy", "０１２３４５６７８９ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ"),
    AUSTRALIAN("Australian", "0⇂ᄅƐㄣގ9ㄥ86ɐqɔpǝɟɓɥıɾʞlɯuodbɹsʇnʌʍxʎz"),
    TINY_FLOATING("Tiny", "⁰¹²³⁴⁵⁶⁷⁸⁹ᵃᵇᶜᵈᵉᶠᵍʰⁱʲᵏˡᵐⁿᵒᵖqʳˢᵗᵘᵛʷˣʸᶻ"),
    ENCIRCLED("Encircled", "⓪①②③④⑤⑥⑦⑧⑨ⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ"),
    CURLIQUE("Curlique", "0123456789αႦƈԃҽϝɠԋιʝƙʅɱɳσρϙɾʂƚυʋɯxყȥ"),
    NORDIC("Nordic", "0123456789ǟɮƈɖɛʄɢɦɨʝӄʟʍռօքզʀֆȶʊʋաӼʏʐ"),
    SOUTHERN("Southern", "0123456789ąცƈɖɛʄɠɧıʝƙƖɱŋơ℘զཞʂɬų۷ῳҳყʑ"),
    ROMANISH("Romanish", "0123456789ΛBᄃDΣFGΉIJKᄂMПӨPQЯƧƬЦVЩXYZ"),
    GREEKISH("Greekish", "0123456789αв¢∂єƒgнιנкℓмησρqяѕтυνωχуz"),
    Y_TITTY("YTitty", "0123456789åß¢Ðê£ghïjklmñðþqr§†µvwx¥z"),
    HIEROGLYPH("Hieroglyph", "0123456789卂乃匚ᗪ乇千Ꮆ卄丨ﾌҜㄥ爪几ㄖ卩Ɋ尺丂ㄒㄩᐯ山乂ㄚ乙"),
    BRACKETS("Brackets", "【0】【1】【2】【3】【4】【5】【6】【7】【8】【9】【a】【b】【c】【d】【e】【f】【g】【h】【i】【j】【k】【l】【m】【n】【o】【p】【q】【r】【s】【t】【u】【v】【w】【x】【y】【z】"),
    CORNER_BRACKETS("Corner brackets", "『0』『1』『2』『3』『4』『5』『6』『7』『8』『9』『a』『b』『c』『d』『e』『f』『g』『h』『i』『j』『k』『l』『m』『n』『o』『p』『q』『r』『s』『t』『u』『v』『w』『x』『y』『z』"),
    DRUNK("Drunk", "⊘1ϩӠ५ƼϬ78९ąҍçժҽƒցհìʝҟӀʍղօքզɾʂէմѵա×վՀ"),
    DERPY("Derpy", "0123456789ᗩᗷᑕᗪEᖴGᕼIᒍKᒪᗰᑎOᑭᑫᖇᔕTᑌᐯᗯ᙭Yᘔ"),
    SHITTY("Shitty", "0123456789ᗩᗷᑢᕲᘿᖴᘜᕼᓰᒚᖽᐸᒪᘻᘉᓍᕵᕴᖇSᖶᑘᐺᘺ᙭ᖻᗱ");

    private final String title;
    private final String chars;
    private static final List<Character> DEFAULT_CHARS;

    private Fonts(String title, String chars) {
        this.title = title;
        this.chars = chars;
    }

    public String apply(String text) {
        StringBuilder translated = new StringBuilder();
        char[] characters = this.chars.toCharArray();
        for (char letter : text.toLowerCase().toCharArray()) {
            int index = DEFAULT_CHARS.indexOf(Character.valueOf(letter));
            if (index == -1) {
                translated.append(letter);
                continue;
            }
            translated.append(characters[index]);
        }
        return translated.toString();
    }

    public String toString() {
        if (((Boolean)Config.get().customFont.get()).booleanValue()) {
            return this.title;
        }
        return this.apply(this.title);
    }

    static {
        DEFAULT_CHARS = Chars.asList(Fonts.DEFAULT.chars.toCharArray());
    }
}
