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
public class Monster {
    
    private String name;
    private int combatlvl;
    private Prize prize;
    private BadConsequence badconsequence;
    private String icon;
    private int levelChangeAgainstCultistPlayer =0;
    

    public String getName() {
        return name;
    }

    public int getCombatlvl() {
        return combatlvl;
    }
    
    Monster(String name, int level, BadConsequence bc, Prize price, String icon)
    {
        this.name = name;
        this.combatlvl = level;
        this.badconsequence = bc;
        this.prize = price;
        this.icon = icon;
    }
    Monster(String name, int level, BadConsequence bc, Prize price, int levelChangeAgainstCultistPlayer, String icon) {
        this(name, level, bc, price, icon);
        this.levelChangeAgainstCultistPlayer = levelChangeAgainstCultistPlayer;
    }

    public BadConsequence getBadConsequence()
    {
        return badconsequence;
    }
    
    public int getLevelsGained()
    {
        return prize.getLvl();
    }

    public Prize getPrize() {
        return prize;
    }
    
    public int getTreasuresGained()
    {
        return prize.getTreasures();
    }
    
    @Override
    public String toString(){
        return "Nombre: "+name+" Nivel de Combate: " +Integer.toString(combatlvl)+"\nRecompensa: "+prize+"\n"+badconsequence;
    }

    public int getLevelChangeAgainstCultistPlayer() {
        return levelChangeAgainstCultistPlayer;
    }
    
    public String getIcon()
    {
        return "/imagen/" + this.icon +  ".jpg";
    }

}
