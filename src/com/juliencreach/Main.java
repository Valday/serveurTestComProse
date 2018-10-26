package com.juliencreach;

public class Main {

    public static void main(String[] args)
    {
        if(args.length != 0)
        {
            System.out.println("argument : "+args[0]);

            switch(args[0])
            {
                case "-s1":
                    System.out.println("serveur TCP 2");
                    serveurTCP1Connexion serveurTCP1 = new serveurTCP1Connexion();
                    serveurTCP1.launchServeur();
                    break;
                case "-s2":
                    System.out.println("serveur TCP 2");
                    break;
                default:
                    System.out.println("Default case");
                    break;
            }
        }
        else
        {
            System.out.println("Pas d'arguments");
        }
    }
}
