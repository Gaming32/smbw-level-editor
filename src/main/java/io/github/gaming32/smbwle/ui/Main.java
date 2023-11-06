package io.github.gaming32.smbwle.ui;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatDarculaLaf.setup();
            new EditorMainWindow();
        });
    }
}
