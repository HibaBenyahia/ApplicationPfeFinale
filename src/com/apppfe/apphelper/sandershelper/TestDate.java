package com.apppfe.apphelper.sandershelper;

import com.apppfe.app.DateHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by hiba on 25/04/2016.
 */
public class TestDate {
    public static void main (String [] args) {


        String dateInString = "Thu Oct 20 00:08:38 CET 2011";
        Date date = DateHelper.parseDateFromString( dateInString ); // chefti had l'instruction , 3lah derna had la conversion ??? pour modifier le type dans la classe lecteur fichier xml hih vasy mala rohi mo
        System.out.println(date.toString());


}
}
