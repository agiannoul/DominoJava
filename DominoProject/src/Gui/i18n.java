package Gui;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *This class is used for internationalization reasons.
 * Mainly to change languages to the Game.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class i18n {
    
    private static ResourceBundle messages;
    
    /**
     * Class Constructor.
     */
    public i18n(){
      
    }
    /**
     * Gets a resource bundle using the specified base name and locale.
     * @param locale a Locale variable of a Country
     */
    public void changeLanguage(Locale locale){
        messages=ResourceBundle.getBundle("Gui.MsgBundle",locale);
    }
    /**
     * Returns a ResourseBundle object.
     * @return  messages
     */
    public ResourceBundle getBundle(){
        return messages;
    }
    
     
}
