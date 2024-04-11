package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton openInfo;

    public MainView(int width, int height){

        setSize(width, height);
        setTitle("User Interface Beispiel");
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setVisible(true);
        addUIComponents();
    }

    /**
     *Erstellt eine Nutzeroberflaeche
     */
    private void addUIComponents(){
        //Panel erzeugen
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        //dem Fenster die erzeugten Panel hinzufügen
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        //Center Panel bekommt flexibles Gridlayout
        centerPanel.setLayout(new GridLayout(1, 3));
        centerPanel.setBorder( new EmptyBorder(5, 5, 5, 5));

        //Label erzeugen und topPanel hinzufügen
        JLabel label = new JLabel("Optionen");
        topPanel.add(label);

        //Button erzeugen und dem bottomPanel hinzufügen
        openInfo = new JButton("Info");
        bottomPanel.add(openInfo);

    }

    /**
     * Fügt einen Eventlistener hinzu, der auf die Methode verweist
     * in dem die eigentliche Funktionalität ausgeführt wird
     */
    public void addInfoButtonHandler( ActionListener listener)
    {
        openInfo.addActionListener(listener);
    }


    /**
     * Zeigt ein Information für den Nutzer in einem Infofenster
     * @param text - Text der angezeigt werden soll
     */
    public void showInfoWindow( String text){
        JOptionPane.showMessageDialog(this, text, "Information", JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmWindow(String text){
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, text, "Bitte bestätige!",JOptionPane.YES_NO_OPTION);
    }




}