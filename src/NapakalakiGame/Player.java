/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.Dice;
import java.util.ArrayList;

/**
 *
 * @author Rusillo
 */
public class Player {
    
    /**
     *
     */
    static final int 
            MAXLEVEL = 10;
    private String name;
    private int level = 1;
    private boolean dead = true;
    private boolean canISteal = true;

    protected Player enemy;

    private BadConsequence pendingBadConsequence = null;
    ArrayList<Treasure> visibleTreasures = new ArrayList();
    ArrayList<Treasure> hiddenTreasures = new ArrayList();
    
    
    public Player(Player p)
    {
        this.name = p.getName();
        this.level = p.getLevels();
        this.visibleTreasures = p.getVisibleTreasures();
        this.hiddenTreasures = p.getHiddenTreasures();
        this.enemy = p.getEnemy();
        this.dead = p.isDead();
        this.pendingBadConsequence = p.getPendingBadConsequence();
        this.canISteal = p.canISteal();
    }
    
    public Player(String name){
       level=1;
       dead=true;
       canISteal=true;
       this.name=name;
       pendingBadConsequence=new NumericBC("", 0,0,0);
       hiddenTreasures= new ArrayList<>();
       visibleTreasures = new ArrayList<>();
   }
    
    public String getName()
    {
       return name;
    }
            
    private void bringToLife()
    {
        if(dead)
        {
            dead = false;
        }
    }
    
    public int getCombatLevel()
    {
        int combatLevel = 0;
        for(Treasure t: visibleTreasures)
        {
            combatLevel += t.getBonus();
        }
        combatLevel += level;
        return combatLevel;
    }

    public Player getEnemy(){
       return enemy;
   }
    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }
    
    private void incrementLevels(int lvl)
    {
        level = level + lvl;
        if(level >10)
        {
            level =10;
        }
    }
    
    private void decrementLevels(int lvl)
    {
        level = level - lvl;
        if(level<1)
        {
            level = 1;
        }
    }
    
    private void setPendingBadConsequence(BadConsequence b)
    {
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m)
    {
       int nLevels = m.getLevelsGained();
       incrementLevels(nLevels);
       int nTreasures = m.getTreasuresGained();
       if(nTreasures>0)
       {
           CardDealer dealer;
           dealer = CardDealer.getInstance();
           Treasure treasure;
           
           for(int i=0;i< nTreasures;i++)
           {
               treasure = dealer.nextTreasure();
               hiddenTreasures.add(treasure);
           }
       }
    }
    
    private void applyBadConsequence(Monster m)
    {
        BadConsequence badConsequence;
        badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad;
        pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
   
    private boolean canMakeTreasureVisible(Treasure t)
    {
        boolean puede_equipar = true;
        int oneHand = 0;

        for(int i = 0; i < visibleTreasures.size() && puede_equipar; i++)
        {
            if( (t.getType() == TreasureKind.ONEHAND) && (visibleTreasures.get(i).getType() == TreasureKind.ONEHAND) )
            {
                oneHand++;
                if(oneHand > 1) puede_equipar = false;
            }

            else if((t.getType() == TreasureKind.ONEHAND) && (visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS))
                puede_equipar = false;

            else if(t.getType() == TreasureKind.BOTHHANDS && this.howManyVisibleTreasures(TreasureKind.ONEHAND) > 0)
                puede_equipar = false;

            else if (t.getType() == visibleTreasures.get(i).getType())
                puede_equipar = false;
        }

        return puede_equipar;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind)
    {
        int ntesoros=0;
        for(int i=0; i<visibleTreasures.size();i++)
        {
            if(visibleTreasures.get(i).getType()==tKind)
            {
                ntesoros++;
            }
        }
        return ntesoros;
    }
    
    private void dieIfNoTreasures()
    {
        int ntesoros = 0;
        ntesoros = visibleTreasures.size() + hiddenTreasures.size();
        
        if(ntesoros == 0)
        {
            dead = true;
        }
    }
    
    public boolean isDead()
    {
        return dead;
    }
    
    public ArrayList <Treasure> getHiddenTreasures()
    {
        return this.hiddenTreasures;
    }
    
    public ArrayList <Treasure> getVisibleTreasures()
    {
        return this.visibleTreasures;
    }
    
    public CombatResult combat(Monster m)
    {
        CombatResult cResult;
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatlvl();
        if(myLevel > monsterLevel)
        {
            
            applyPrize(m);
            if(level >= MAXLEVEL)
                cResult = CombatResult.WINGAME;
            else
                cResult = CombatResult.WIN;
        }
        else
        {
            applyBadConsequence(m);
            if(shouldConvert())
            {
                cResult = CombatResult.LOSEANDCONVERT;
            }
            else
                cResult = CombatResult.LOSE;     
        }

        return cResult;
    }
    

   public void makeTreasureVisible(Treasure t){
       boolean canI=canMakeTreasureVisible(t);
       if(canI){
           visibleTreasures.add(t);
           hiddenTreasures.remove(t);
       }
   
    }
    
    public void discardVisibleTreasure(Treasure t)
    {
       visibleTreasures.remove(t);
       
       if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
           pendingBadConsequence.substractVisibleTreasure(t);
   
       dieIfNoTreasures();
        
    }
    
    public void discardHiddenTreasure(Treasure t)
    {
       hiddenTreasures.remove(t);
       
       if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
           pendingBadConsequence.substractHiddenTreasure(t);
   
       dieIfNoTreasures();
    }
    
    public boolean validState()
    {
        int ntesoros;
        ntesoros = hiddenTreasures.size();

        return ((pendingBadConsequence == null || pendingBadConsequence.isEmpty()) && ntesoros <= 4);
    }
    
    public void initTreasures()
    {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        
        
        if(number==6)
        {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure); //3 tesoros
            
        }
        
        if(number==1)
        {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure); //1 tesoro
        }
        if(1<number && number<6)
        {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);  //dos tesoros
            
        }
        

    }
    
    public int getLevels()
    {
        return level;
    }
    
    public Treasure stealTreasure()
    {
        boolean canI=canISteal();
        
        if(canI)
        {
            boolean canYou=enemy.canYouGiveMeATreasure();
            
            if(canYou)
            {
                Treasure treasure=enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
                return treasure;
            }
            
        }
        return null;
    }
    
    public void setEnemy(Player enemy)
    {
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure()
    {
        Treasure tesorito;
        int pos = (int) (Math.random() * hiddenTreasures.size());
        tesorito = hiddenTreasures.get(pos);
        hiddenTreasures.remove(pos);
        return tesorito;
    }
    
    public boolean canISteal(){
        return this.canISteal;
    }
    
    private boolean canYouGiveMeATreasure()
    {
        return !(hiddenTreasures.isEmpty());
    }
    
    private void haveStolen()
    {
        if(!hiddenTreasures.isEmpty())
        {
            canISteal = false;
        }
        else
            canISteal = true;
    }
    
    protected int getOponentLevel(Monster m) {

        return m.getCombatlvl();

    }
    
   protected boolean shouldConvert(){
       Dice dice = Dice.getInstance();
       return dice.nextNumber()==1;
   }
   
   public void discardAllTreasures(){
       ArrayList<Treasure> vcopia = new ArrayList(visibleTreasures);
       for(int i=0; i < vcopia.size();i++){
           discardVisibleTreasure(vcopia.get(i));
       }
       
       ArrayList<Treasure> hcopia = new ArrayList(hiddenTreasures);
       for(int i=0; i< hcopia.size();i++){
           discardHiddenTreasure(hcopia.get(i));
       }
   }
   
   public void stealToPreviousPlayer()
   {
       
   }
}

