package controller;

import java.util.ArrayList;

import Model.*;

public class ClientManager {
    
    public ArrayList<Client> clients;

    public ClientManager() {
        clients = new ArrayList<>();
        //Create a default client
        Client client1 = new Client("rayan", "mozali", "rayanmozali@gmail.com", 
                "0000", "rayan", "momo");
        addClient(client1);
    }
    
    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }
    
    public boolean isClient(String username, String password ){
        //Check if the client credentials match with the stored client credentials
        for(Client client : clients){
            if((client.username.equals(username) || client.Email.equals(username) || client.PhoneNumber.equals(username))
                && (client.password.equals(password))){
                return true;
            }
        }
        
        //If client credentials don't match, add the client to the clients list
        return false;
    }

    
    public Client getClient(String username, String password){
        //Check if the client credentials match with the stored client credentials
        for(Client client : clients){
            if((client.username.equals(username) || client.Email.equals(username) || client.PhoneNumber.equals(username))
                && (client.password.equals(password))){
                return client;
            }
        }
        
        //If client credentials don't match, return null
        return null;
    }


}
