/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.*;
//import GUI.NapakalakiView;
//import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author Rusillo
 */
public class main {

    public static void main(String[] args) {
        
        ArrayList<String> names;
        PlayerNamesCapture namesCapture;
        
        //Obtenemos el singleton del juego
        Napakalaki game = Napakalaki.getInstance();

        //Inicializamos el juego
        
        NapakalakiView napakalakiView = new NapakalakiView();
        
        
        Dice.createInstance(napakalakiView);
        
        namesCapture = new PlayerNamesCapture(napakalakiView, true);
       
        names = namesCapture.getNames();
    
        game.initGame(names);
        
        napakalakiView.setNapakalaki(game);
        
        napakalakiView.setVisible(true);
        
    }
    
}
