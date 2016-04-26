package com.apppfe.apphelper.sandershelper;

import java.util.ArrayList;

/**
 * Created by hiba on 24/04/2016.
 */
public class MainSandersHelper {

    public static void main (String [] args){
        ArrayList<InfoDataset> listeDeTweet;

        // test d'affichage tweet
        // Tweet tweet = new Tweet();
        // tweet.setSentiment(1.2);
        // System.out.println( tweet.toString() );//si tu veut j'affiche attnd

        // test de la lecture du fichier xml
        LecteurFichierXml lecteurFichierXmlXml = new LecteurFichierXml();
        lecteurFichierXmlXml.lireFichierDeTweet();

        System.out.println("le nombre de tweets en anglais est :"+ lecteurFichierXmlXml.getNombreTweetsAnglais() );
//nombre de tweet total
        System.out.println("le nombre de tweets total : " + lecteurFichierXmlXml.getNomblreTotalTweetARecuperer());
        System.out.println("La taille de la liste de tweet : "+ lecteurFichierXmlXml.getListeDeTweet().size() );

        //lecture du fichier CSV
        InfoDatasetFactory  infoDatasetFactory = new InfoDatasetFactory("C:\\Users\\hiba\\Desktop\\HibaPFE\\PFEMaster\\Impl\u00e9mentationApp + r\u00e9daction\\datasets\\sanders-dataset-twitter-0-2\\corpus.csv");
        infoDatasetFactory.construireListeInfoDataset();
infoDatasetFactory.getListOfInfodataset();
      //  int sentimentPolarite= 0;
        //if (InfoDatasetFactory.sentiment.equals("positive")){
          //  sentimentPolarite = 1;
       // }else if(sentiment.equals("negative")) {
        //    sentimentPolarite = 0;
        //}else if(sentiment.equals("neutral")){
          //  sentimentPolarite = -1;
        //}else
        //{
          //  sentimentPolarite= -2;
        //}
//parcourir la liste de csv afficher

        //- j'obtien la liste de tweet
        LecteurFichierXml lecteurFichierXml = new LecteurFichierXml();
        lecteurFichierXml.lireFichierDeTweet();
        ArrayList<Tweet> listeDeTweetDuFichierXml = lecteurFichierXml.getListeDeTweet();

        //     - j'obtien la liste de indoDataset
InfoDatasetFactory infoDatasetFactory2 = new InfoDatasetFactory("C:\\Users\\hiba\\Desktop\\HibaPFE\\PFEMaster\\Impl\u00e9mentationApp + r\u00e9daction\\datasets\\sanders-dataset-twitter-0-2\\corpus.csv");
        infoDatasetFactory2.construireListeInfoDataset();
        ArrayList<InfoDataset> listeDeFichierCsv = infoDatasetFactory2.getListOfInfodataset();


        //    - je parcours la liste de tweet
        for(int i=0; i<listeDeTweetDuFichierXml.size(); i++){

            //   - pour chaque tweet je prend son id
            String idDeTweet = listeDeTweetDuFichierXml.get(i).getId();


            // - je chercher cet id dans la liste de infodataset
                 //pour chaque InfoDataset de la listeDEFichierCSV
            for(InfoDataset infoDataset: listeDeFichierCsv){
                //tester si l'element infoDataset a le meme idée que t'a récupéré
                if(infoDataset.getIdTweet().equals(idDeTweet)) {
                    String sentimentCsv = infoDataset.getSentiment();
                    double sentiment = 0.0;
                    if (sentimentCsv.equals("positive")) {
                        sentiment = 1.0;
                    } else if (sentimentCsv.equals("negative")) {
                        sentiment = -1.0;
                    } else if (sentimentCsv.equals("neutral")) {
                        sentiment = 0.0;
                    } else {
                        sentiment = 9.0;
                    }
                    //- quand je le trouve j'obtien le sentiment

                    //ok doka raho andek le sentiment, alors tu modifie le sentiment de ce tweet n°i
                    listeDeTweetDuFichierXml.get(i).setSentiment(sentiment);
                    break;
                }
            }




        }
        // - j'affiche le tweet pour tester
       // System.out.println("affichage de Tweet avec son sentiment " + listeDeTweetDuFichierXml);
        for (Tweet tweet : listeDeTweetDuFichierXml){
            System.out.println( tweet.toString() );
        }

        //je met ma listeDeTweet avec sentiment à la place de la liste de l'objet lecteur
        lecteurFichierXml.setListeDeTweet( listeDeTweetDuFichierXml );

        //calculer le nombre de tweets pos, neg, neutre et irrelevent.
        lecteurFichierXml.calculerNomNobmbreDeTweetPositif();
        System.out.println("Le nombre de tweet positifs :  " + lecteurFichierXml.getNombreDeTweetPositif());

        lecteurFichierXml.calculerNomNobmbreDeTweetNegatif();
        System.out.println( "Le nombre de tweet négatif :  "+ lecteurFichierXml.getNombreDeTweetNegatif());

        lecteurFichierXml.calculerNomNobmbreDeTweetNeutre();
        System.out.println( "Le nombre de tweet neutre :  "+ lecteurFichierXml.getNombreDeTweetNeutre());

        lecteurFichierXml.calculerNomNobmbreDeTweetIrrelevent();
        System.out.println( "Le nombre de tweet irrelevent :  "+ lecteurFichierXml.getNombreDeTweetIrrelevent());

        //maintent tu soit ajouter les méthodes : get nombre de tweet positive
        // get nombre de tweet negative, get nombre de tweet irrele, get nbr tweet neutre dans la classe lecteur fichier xml

//enregistrement dans un fichier xml
        //kan andna Lecteur fichier xml w doka sa fait w ch ndiro ?
        // EnregstreurFichier Xml hhh sahlaok c ton propre resonnement mat9olich sahla
  EnregistreurFichierXml enregistreurFichierXml = new EnregistreurFichierXml();
        enregistreurFichierXml.enregistrerXmlFile(listeDeTweetDuFichierXml);

      }
}
