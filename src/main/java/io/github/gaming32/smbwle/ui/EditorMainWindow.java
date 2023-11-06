package io.github.gaming32.smbwle.ui;

import io.github.gaming32.smbwle.util.SwingUtils;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class EditorMainWindow extends JFrame {
    public EditorMainWindow() {
        super("SMBW Level Editor");

        initUi();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void initUi() {
        final JMenuBar menuBar = new JMenuBar();

        final JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        fileMenu.add(SwingUtils.newMenuItem("Open Map", KeyEvent.VK_O, e -> {
        }));

        setJMenuBar(menuBar);
    }
}
