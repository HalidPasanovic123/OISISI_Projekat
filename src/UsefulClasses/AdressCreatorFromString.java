package UsefulClasses;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Adresa;

//String mora biti formata Ulica Broj, Grad, Drzava
public class AdressCreatorFromString {
    
    public static Adresa createAdresa(String adresa){
        final Pattern regexStrings = Pattern.compile("([a-zA-ZÄŤÄŚÄ‡Ä†ĹľĹ˝Ä‘Ä�ĹˇĹ ]+[\\s]*)+");
        final Pattern regexNumber = Pattern.compile("[0-9]+");
        final Matcher tempString = regexStrings.matcher(adresa);
        final Matcher stringNumber = regexNumber.matcher(adresa);

        ArrayList<String> strings = new ArrayList<String>();

        while (tempString.find()) {
            strings.add(tempString.group());
        }
        
        stringNumber.find();

        return new Adresa(strings.get(0).trim(), Integer.parseInt(stringNumber.group()), strings.get(1).trim(), strings.get(2).trim());
    }
}
