package com.apppfe.apphelper.sandershelper;

/**
 * Created by hiba on 26/04/2016.
 */
public class InfoDataset {
    private String firme ;
    private String sentiment ;
    private String idTweet ;

    public InfoDataset(String firme, String sentiment, String idTweet) {
        this.firme = firme;
        this.sentiment = sentiment;
        this.idTweet = idTweet;
    }

    public String getFirme() {
        return firme;
    }

    public void setFirme(String firme) {
        this.firme = firme;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getIdTweet() {
        return idTweet;
    }

    public void setIdTweet(String idTweet) {
        this.idTweet = idTweet;
    }

    @Override
    public String toString() {
        return "InfoDataset{" +
                "firme='" + firme + '\'' +
                ", sentiment='" + sentiment + '\'' +
                ", idTweet='" + idTweet + '\'' +
                '}';
    }
}
