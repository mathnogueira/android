package pink.dcc.ufla.br.wiplayer.models;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String author;
    private int duration;
    private String genre;
    private String src;

    private boolean isPlaying;

    public Song(int id, String title, String author, int duration) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.isPlaying = false;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
