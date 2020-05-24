package JIntellitypeTest;

import com.melloware.jintellitype.JIntellitype;

public class HotKeyEnter {

    public static void main(String[] args) {
        JIntellitype.getInstance().addHotKeyListener(new ListenOfHotkey());
        JIntellitype.getInstance().addIntellitypeListener(new ListenOfIntellitype());
        JIntellitype.getInstance().registerHotKey(1,JIntellitype.MOD_ALT+JIntellitype.MOD_SHIFT,(int)'a');
    }

}
