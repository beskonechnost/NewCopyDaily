import TimersTasks.TimerTaskDaily;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Андрей on 14.12.2017.
 */
public class TrayIconExample {
    public static final String APPLICATION_NAME = "AutoLoader";
    public static final String ICON_STR = "C:\\mainPawn\\CopyFile\\icon.png";

    private static java.util.Timer mTimer;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();

                if (mTimer != null) {
                    mTimer.cancel();
                }

                Date d = new Date();
                d.setHours(9);
                d.setMinutes(0);
                d.setSeconds(0);
                d.setDate(d.getDate());

                mTimer = new Timer();
                TimerTaskDaily ttd = new TimerTaskDaily();

                mTimer.schedule(ttd,d,86400000);

            }
        });
    }

    private static void createGUI() {
        JFrame frame = new JFrame(APPLICATION_NAME);
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        setTrayIcon();
    }

    private static void setTrayIcon() {
        if(! SystemTray.isSupported() ) {
            return;
        }

        PopupMenu trayMenu = new PopupMenu();
        MenuItem item = new MenuItem("Exit");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayMenu.add(item);

        Image icon = Toolkit.getDefaultToolkit().createImage(ICON_STR);
        TrayIcon trayIcon = new TrayIcon(icon, APPLICATION_NAME, trayMenu);
        trayIcon.setImageAutoSize(true);

        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        trayIcon.displayMessage(APPLICATION_NAME, "Auto loader started!",
                TrayIcon.MessageType.INFO);
    }
}
