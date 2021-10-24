package aptech.project2.nhom2.util;

import org.apache.commons.lang3.StringUtils;

public class StringNomaliser {
    public static String removeAccentedCharacter(String text) {
        return StringUtils.stripAccents(text);
    }
    
}
