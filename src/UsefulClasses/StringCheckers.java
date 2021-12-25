package UsefulClasses;

import java.util.regex.Pattern;

public class StringCheckers {

    public static boolean checkAdresa(String adresa) {
        return Pattern.matches("([a-zA-ZÄŤÄŚÄ‡Ä†ĹľĹ˝Ä‘Ä�ĹˇĹ ]+[\\s]*)+[0-9]+[,][\\s]*([a-zA-ZÄŤÄŚÄ‡Ä†ĹľĹ˝Ä‘Ä�ĹˇĹ ]+[\\s]*)+[,][\\s]*([a-zA-ZÄŤÄŚÄ‡Ä†ĹľĹ˝Ä‘Ä�ĹˇĹ ]+[\\s]*)+", adresa);
    }

    public static boolean checkImeOrPrezime(String ime_or_prezime) {
        return Pattern.matches("[a-zA-ZÄŤÄŚÄ‡Ä†ĹľĹ˝Ä‘Ä�ĹˇĹ ]+[\\s]*", ime_or_prezime);
    }

    public static boolean checkTelefon(String telefon) {
        return Pattern.matches("[+]?[0-9]+", telefon);
    }

    public static boolean checkEmail(String eMail) {
        return Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", eMail);
    }

    public static boolean checkZvanje(String zvanje) {
        return Pattern.matches("([a-zA-ZÄŤÄŚÄ‡Ä†ĹľĹ˝Ä‘Ä�ĹˇĹ ]+[\\s]*)+", zvanje);
    }
    
}
