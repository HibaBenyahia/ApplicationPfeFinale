package com.apppfe.apphelper.sandershelper;

import com.apppfe.apphelper.sandershelper.InfoDataset;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by hiba  on 26/04/2016.
 */
public class InfoDatasetFactory {

    //attributs
    private String path ;
    private ArrayList<InfoDataset> listOfInfodataset;



    //constructeur

    public InfoDatasetFactory(String path) {
        this.path = path;
        this.listOfInfodataset = new ArrayList<InfoDataset>();
    }



    //methodes
    public void construireListeInfoDataset() {

        Reader in = null;
        try {
            in = new FileReader(this.path);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
            for (CSVRecord record : records) {

                String valeur = record.get(0);
                System.out.println(valeur);

                String[] tabValeur = valeur.split(",");

                String firme = tabValeur[0];
                String sentiment = tabValeur[1].substring(1, tabValeur[1].length()-1);

                String idTweet = tabValeur[2].substring(1, tabValeur[2].length()-1);  // "39433943947394739743497"  ->  3949849584437487348

                InfoDataset infoDataset = new InfoDataset(firme, sentiment, idTweet);
                this.listOfInfodataset.add(infoDataset);
                System.out.println(infoDataset.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<InfoDataset> getListOfInfodataset() {
        return listOfInfodataset;
    }

    public void setListOfInfodataset(ArrayList<InfoDataset> listOfInfodataset) {
        this.listOfInfodataset = listOfInfodataset;
    }

    @Override
    public String toString() {
        return "InfoDatasetFactory{" +
                "path='" + path + '\'' +
                ", listOfInfodataset=" + listOfInfodataset +
                '}';
    }
}
