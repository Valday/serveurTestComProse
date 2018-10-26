package com.juliencreach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serveurTCP1Connexion
{
    final static int port = 54321;

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socketClient;
    private ServerSocket socketServeur;

    public serveurTCP1Connexion()
    {
    }

    public void launchServeur()
    {
        System.out.println("Hello serveur TCP 1 connexion!");
        boolean isAlive = true;

        try
        {
            this.socketServeur = new ServerSocket(port);

            System.out.println("Lancement du serveur - Ip : " );
            this.socketClient = this.socketServeur.accept();
            System.out.println("Connexion avec : "+ this.socketClient.getInetAddress());

            this.dataInputStream = new DataInputStream(socketClient.getInputStream());
            this.dataOutputStream = new DataOutputStream(socketClient.getOutputStream());

            while (isAlive)
            {
                String message = "";


                int length = this.dataInputStream.readInt();
                if(length > 0)
                {
                    byte[] data = new byte[length];
                    this.dataInputStream.readFully(data, 0, data.length);
                    message = new String(data);

                    this.dataOutputStream.writeInt(data.length);
                    this.dataOutputStream.write(data);
                    this.dataOutputStream.flush();
                }
                System.out.println("Message : "+ message);




                //socketClient.close();
                if(this.socketClient.isClosed())
                {
                    isAlive = false;
                    System.out.println("Connection closed !");
                }
            }
        }
        catch (IOException e)
        {
           //e.printStackTrace();
            System.out.println(" ==> Perte de connexion avec le client");
        }

    }
}

