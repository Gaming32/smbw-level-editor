package io.github.gaming32.smbwle.util;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SwingUtils {
    public static JMenuItem newMenuItem(String text, int mnemonic, ActionListener action) {
        final JMenuItem menuItem = new JMenuItem(text, mnemonic);
        menuItem.addActionListener(action);
        return menuItem;
    }
}
