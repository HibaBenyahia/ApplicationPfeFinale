package com.apppfe.apphelper.sandershelper;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import twitter4j.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiba on 26/04/2016.
 */
public class EnregistreurFichierXml {

    //les eattributs
    private Document doc;
    private Element tweets;

    //constructeur
    public EnregistreurFichierXml() {
        tweets = new Element("tweets");
        doc = new Document(tweets);
        // doc.setRootElement(tweets);
    }

    //methodes
    public void enregistrerXmlFile( ArrayList<Tweet> tweetList){ // hna tebda khadmtek je dois faire une liste comme parametre!!!! oui tu va le passer une Array liste de tweet non tweet par tweet !! list
        for(Tweet tweet : tweetList){

            String id = tweet.getId();
            int nbrFavoris = tweet.getFavoris();
            String lang = tweet.getLangue();
            String place = tweet.getPlacename();
            Location loc = tweet.getLocation();
            int nbrRetweet = tweet.getRetweet();
            String user = tweet.getUser();
            String msg = tweet.getTweettext();
            String date = tweet.getDate().toString();
            double sentiment = tweet.getSentiment();


            Element tweetElement = new Element("tweet");
            tweetElement.setAttribute(new Attribute("id", id ));
            tweetElement.addContent(new Element("user").setText( user ));
            tweetElement.addContent(new Element("tweettext").setText( msg ));
            if (loc != null){
                Element geoloc = new Element("location");
                geoloc.addContent(new Element("latitude").setText( tweet.getLocation().getLatitude()+"" ));
                geoloc.addContent(new Element("longitude").setText( tweet.getLocation().getLongitude()+"" ));
                tweetElement.addContent(geoloc);
            }
            tweetElement.addContent(new Element("date").setText( date ));
            tweetElement.addContent(new Element("favoris").setText( nbrFavoris+"" ));
            tweetElement.addContent(new Element("language").setText( lang ));
            if (place != null){
                tweetElement.addContent(new Element("placename").setText( place ));
            }
            tweetElement.addContent(new Element("retweets").setText( nbrRetweet + "" ));
            tweetElement.addContent(new Element("sentiment").setText( sentiment + "" ));

            doc.getRootElement().addContent(tweetElement);




        }

        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter("sanders_dataset_tweets_sentiment.xml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Fichier Xml de tweets a été enregistré avec succès !");

    }


}
