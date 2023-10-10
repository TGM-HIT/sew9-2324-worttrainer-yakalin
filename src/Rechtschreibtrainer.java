import service.WortService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

public class Rechtschreibtrainer {

    private int score, rounds;

    private boolean running = true;

    private WortService service;

    public Rechtschreibtrainer() throws IOException {
        this.service = new WortService();
        int[] array = service.loadData("data.json");
        this.rounds = array[0];
        this.score = array[1];
        startTrainer();
    }

    public void startTrainer() throws IOException {
        String input = "";
        String text = "";
        while(running) {
            URL url = new URL(service.getRandomWord().getUrl());
            text = "Rundenzahl: " + this.rounds + "\nPunkte: " + this.score + "\nWort eingeben: ";
            input = this.input(url, text);

            if(input != null && input.equals("exit")){
                this.running = false;
                service.saveData("data.json", this.rounds, this.score);
            }
            else{
                if(service.validateUserInput(url.toString(), input)){
                    this.score++;
                }
                this.rounds++;
            }

        }
    }

    public String input(URL url, String text) throws IOException {
        Image image = ImageIO.read(url);
        BufferedImage resizedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, 200, 200, null);
        graphics2D.dispose();
        ImageIcon icon = new ImageIcon(resizedImage);
        JOptionPane.showMessageDialog(null, icon);
        return JOptionPane.showInputDialog(null, text);
    }

    public static void main(String[] args) throws IOException {
        new Rechtschreibtrainer();
    }
}
