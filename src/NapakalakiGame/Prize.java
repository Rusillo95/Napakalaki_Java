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
public class Prize {
    
    private int treasures;
    private int lvl;
    
    public Prize(int treasures, int lvl){
        this.treasures = treasures;
        this.lvl = lvl;
}

    public int getTreasures() {
        return treasures;
    }

    public int getLvl() {
        return lvl;
    }
    
    public String toString()
    {
        return "Tesoros: "+treasures+" Niveles: "+lvl;
    }
}
