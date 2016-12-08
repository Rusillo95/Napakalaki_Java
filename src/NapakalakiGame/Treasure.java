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
public class Treasure {

    /*************/
    /* variables */
    /*************/
    
    private String name;
    private int bonus;
    
    private TreasureKind type;
    
    //PARA GUI
    private String icon;
    
    
    /*************/
    /* functions */
    /**
     * @param name     
     * @param bonus     
     * @param type     
     * @param icon     
     */
    
    public Treasure(String name, int bonus, TreasureKind type, String icon)
    {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public TreasureKind getType() {
        return type;
    }
    
    @Override
    public String toString()
    {
        return "\nNombre: "+name+", Bonus: "+bonus+", Tipo: "+type;
    }
    
    public String getIcon() {
        return "/imagen/" + this.icon +  ".jpg";
    }
    
}
