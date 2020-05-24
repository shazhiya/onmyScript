package JIntellitypeTest;

import com.melloware.jintellitype.IntellitypeListener;

public class ListenOfIntellitype implements IntellitypeListener {
    /**
     * Event fired when a WM_APPCOMMAND message is received that was initiated
     * by this application.
     * <p>
     *
     * @param command the WM_APPCOMMAND that was pressed
     */
    @Override
    public void onIntellitype(int command) {
        System.out.println(command);
    }
}
