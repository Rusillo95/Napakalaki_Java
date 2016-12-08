/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Rusillo
 */
public class DeathBC extends NumericBC{
 Player player;
    private boolean death;
    
    public DeathBC(String text, boolean death){
        super(text,10,MAXTREASURES, MAXTREASURES);
        this.death = death;
    }
    
    public boolean getDeath(){
        return death;
    }
    
}
