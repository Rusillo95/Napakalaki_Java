/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Rusillo
 */
public class CultistPlayer extends Player {
    
    private int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    
    
    CultistPlayer(Player p, Cultist c) {

        super(p);

        this.myCultistCard = c;
        totalCultistPlayers++; 

    }
    
    
    @Override
   public int getCombatLevel()
   {
       return ((super.getCombatLevel()*20)/100)+(myCultistCard.getGainedLevels()*totalCultistPlayers);
   }
   
   
   @Override
    public boolean shouldConvert() {

        //Siempre devuelve false
        return false;
    }
    
    public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }

    @Override
    public int getOponentLevel(Monster m) {

        return m.getLevelChangeAgainstCultistPlayer();

    }
    
    Treasure giveMeATreasure(){

        Random rndm=new Random();
        int rndmTreasure=rndm.nextInt(visibleTreasures.size())-1;
        
        return visibleTreasures.get(rndmTreasure);
    }
    
    boolean canYouGiveMeATreasure()
    {
        ArrayList<Treasure> tesoros = enemy.getVisibleTreasures();
        if(tesoros.size()>0)
            return true;
        return false;
    }
    public Cultist getMyCulstist()
    {
        return myCultistCard;
    }
    
    
}
