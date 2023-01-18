import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public static String[] gallows = {
            "+---+\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};


    public static void main(String[] args) {




        char yesOrno = 'y';

        while(yesOrno == 'y'){
            int essay =  6;
            int erreur = 0;




            int number = numberRandom(words);
            String motMystere = words[number];
            char devine = ' ';


            char[] listeWrongChar = new char[essay];
            for(int i = 0;i< essay; i++){

                listeWrongChar[i] = ' ';
            }
            char[] indexChar = new char[charListe(motMystere).length];

            for(int i = 0;i< charListe(motMystere).length; i++){

                indexChar[i] = '_';
            }

            String resultat = "";

            while(true){


                affiche(gallows, erreur);
                afficheCharWord(devine,charListe(motMystere),indexChar);
                wrongTableau(listeWrongChar);
                if(Arrays.equals(indexChar , charListe(motMystere))){

                    resultat = "You win";
                    break;




                }
                if (erreur == 6){


                    resultat = "You loose";
                    break;
                }
                //System.out.print( motMystere + "\n");
                devine = guess();

                erreur = misses(check(devine,charListe(motMystere)),erreur,devine,listeWrongChar);






            }

            System.out.println(resultat);
            if(resultat.equals("You loose")){

                System.out.println("Le mot mystére est : " + motMystere);
            }

            Scanner input = new Scanner(System.in);

            System.out.print("Do you want to play again y/n : ");

            yesOrno = input.next().charAt(0);


        }







    }





    public static void afficheCharWord(char lettre,char[] listeLettre,char[] indexChar){
        System.out.print("Word : ");

        for( int i  = 0 ; i < listeLettre.length;i++){

           if (lettre == listeLettre[i]){

               indexChar[i] = lettre;

            }

            System.out.print(indexChar[i]);

        }

        System.out.print("\n");

    }

    public static int numberRandom(String[] word) {

        double number = (Math.random() * word.length) + 1;


        return (int) number;
    }

    public static char guess() {
        Scanner input = new Scanner(System.in);

        System.out.print("Guess : ");
        char charactere = input.next().charAt(0);


        return charactere;


    }

    public static void affiche(String[] picture, int wrong) {


        System.out.println(picture[wrong]);


    }


    public static char[] charListe(String motRandom) {


        char[] lettremot = new char[motRandom.length()];

        for (int i = 0; i < motRandom.length(); i++) {


            lettremot[i] = motRandom.charAt(i);

        }
        return lettremot;
    }

    public static boolean check (char lettre, char[] liste){

        for( int i = 0 ; i < liste.length;i++){

            if (lettre == liste[i]){


                return true;
            }

        }

        return false;

    }

    public static int misses(boolean checkk,int erreur, char lettre, char[] listeWrongChar ) {



        if(checkk == false){

            listeWrongChar[erreur] = lettre;

            erreur++;

        }



        System.out.print("\n");
        return erreur;
    }

    public static void wrongTableau(char[] wrongTableau){
        System.out.print("Misses : ");
        for (int i = 0;i < wrongTableau.length;i++){

            System.out.print(wrongTableau[i]);
        }
        System.out.print("\n");



    }

}