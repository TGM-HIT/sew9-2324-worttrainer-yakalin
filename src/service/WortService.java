package service;
import models.Wortpaar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;
import java.util.*;

/**
 * Diese Klasse hat alle relevanten Funktionen für die Wortmap.
 * @author yakalin
 * @version 18.09.2023
 */
public class WortService {
    // Diese Map hat als Key die URL und als value das Wort
    private final List<Wortpaar> wortliste = new ArrayList<>();
    private final PersistencyService persistencyService = new JSONService();

    public WortService(){
        wortliste.add(new Wortpaar("https://www.bmel.de/SharedDocs/Bilder/DE/_Tiere/Haus-Zootiere/tierschutz-hunde.jpg?__blob=wide&v=3", "hund"));
        wortliste.add(new Wortpaar("https://www.kindernetz.de/wissen/tierlexikon/1655279778114,steckbrief-katze-102~_v-16x9@2dL_-6c42aff4e68b43c7868c3240d3ebfa29867457da.jpg", "katze"));
        wortliste.add(new Wortpaar("https://cdn.pixabay.com/photo/2013/07/13/10/51/football-157930_1280.png", "ball"));
    }

    public Wortpaar getRandomWord() {
        Random gen = new Random();
        int randomNumber = gen.nextInt(this.wortliste.size())+1;
        Iterator<Wortpaar> it = this.wortliste.iterator();
        Wortpaar randomWord = null;
        for(;randomNumber != 0; randomNumber--){
            randomWord = it.next();
        }
        return randomWord;
    }

    public boolean validateUserInput(String url, String input){
        input = input.toLowerCase();
        Iterator<Wortpaar> it = this.wortliste.iterator();
        Wortpaar wp;
        while(it.hasNext()){
            wp = it.next();
            if(wp.getUrl().equals(url)){
                return wp.getWord().equals(input);
            }
        }
        return false;
    }

    public int[] loadData(String path){
        JSONObject data = persistencyService.read(path);
        int[] array = new int[2];
        if(data != null) {
            int rounds = Integer.parseInt(data.get("rounds").toString());
            int score = Integer.parseInt(data.get("score").toString());
            array[0] = rounds;
            array[1] = score;
        }
        else{
            array[0] = 0;
            array[1] = 0;
        }
        return array;
    }

    public void saveData(String path, int rounds, int score){
        persistencyService.save(path, rounds, score);
    }
}