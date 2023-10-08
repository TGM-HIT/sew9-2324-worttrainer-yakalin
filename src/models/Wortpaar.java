package models;

public class Wortpaar {
    private String url, word;

    public Wortpaar(String url, String word){
        this.url = url;
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
