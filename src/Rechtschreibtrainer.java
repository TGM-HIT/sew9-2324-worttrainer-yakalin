import service.WortService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Rechtschreibtrainer {

    private int score, rounds;

    private WortService service;

    public Rechtschreibtrainer() throws IOException {
        this.score = 0;
        this.rounds = 0;
        this.service = new WortService();
        showWord();
    }

    public void showWord() throws IOException {
        URL url = new URL(service.getRandomWord().getUrl());
        Image img = ImageIO.read(url);
        JOptionPane.showInputDialog(null, "Wort eingeben: ", img);
    }

    public static void main(String[] args) throws IOException {
        new Rechtschreibtrainer();
    }
}
