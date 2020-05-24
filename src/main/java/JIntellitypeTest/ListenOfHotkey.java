package JIntellitypeTest;

import com.melloware.jintellitype.HotkeyListener;

public class ListenOfHotkey  implements HotkeyListener {
    /**
     * Event fired when a WM_HOTKEY message is received that was initiated
     * by this application.
     * <p>
     *
     * @param identifier the unique Identifer the Hotkey was assigned
     */
    @Override
    public void onHotKey(int identifier) {
        if (identifier == 1) {
            System.out.println("pressed key shift+alt+a");
        }
    }
}
