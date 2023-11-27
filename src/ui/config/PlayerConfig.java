package ui.config;

import javax.swing.*;

public class PlayerConfig {
    public int id;
    public JLabel jlPlayerChoose = null;
    public final JLabel jlPlayerSelected = new JLabel(Photo.PLAYER_01_SELECTED);
    public JButton leftButton;
    public JButton rightButton;
    public JButton confirmButton;
    public JLabel jbnPlayerNameLabel = new JLabel("Name:");
    public JTextField jbnPlayerNameField = new JTextField(12);
    public PlayerConfig(int id){
        this.id=id;
    }
}
