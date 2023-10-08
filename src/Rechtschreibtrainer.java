import service.WortService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Rechtschreibtrainer {

    private int score, rounds;

    private boolean running = true;

    private WortService service;

    public Rechtschreibtrainer() throws IOException {
        this.score = 0;
        this.rounds = 0;
        this.service = new WortService();
        startTrainer();
    }

    public void startTrainer() throws IOException {
        String input = "";
        String text = "";
        while(running) {
            URL url = new URL(service.getRandomWord().getUrl());
            text = "Rundenzahl: " + this.rounds + "\nPunkte: " + this.score + "\nWort eingeben: ";
            input = this.input(url, text);

            if(input.equals("exit")){
                this.running = false;
            }
            else{
                if(service.validateUserInput(url.toString(), input)){
                    this.score++;
                }
                this.rounds++;
            }

        }
    }

    public String input(URL url, String text){
        Icon img = new ImageIcon(url.toString());
        return (String) JOptionPane.showInputDialog(null, text, "", JOptionPane.QUESTION_MESSAGE, img, null, "");
    }

    public static void main(String[] args) throws IOException {
        new Rechtschreibtrainer();
    }
}
