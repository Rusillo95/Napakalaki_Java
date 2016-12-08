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
public class Napakalaki {

    /*************/
    /* variables */
    /*************/
    
    private static Napakalaki instance = null;
    

    private ArrayList <Player> players = new ArrayList();
    private CardDealer dealer = CardDealer.getInstance();
    private Player currentPlayer;
    private Monster currentMonster;
    private CultistPlayer cd;
    
    
    /*************/
    /* functions */
    /*************/
    
    private Napakalaki()
    {
        
    }
    private void initPlayers(ArrayList<String> names) {

        //Inicializamos el array de jugadores
        players = new ArrayList();

        //Recorremos los nombres pasados y creamos tantos jugadores como nombres
        names.stream().forEach((s) -> {
            players.add(new  Player(s));    
        });
    }
    
    //EXAMEN
    public void stealToPreviousPlayer()
    {
        int IndexAnterior;
        Player anteriorP;
        
        int currentPIndez = this.players.indexOf(this.currentPlayer);
        if(currentPIndez == 0)
            IndexAnterior=players.size()-1;
        else
            IndexAnterior=currentPIndez-1;
        
        anteriorP=this.players.get(IndexAnterior);
        Treasure aux;
        Treasure maximo = null;
        int bonus;
        int mayor=0;
        if(anteriorP.hiddenTreasures.isEmpty())
        {
            System.out.println("\nNo se puede ROBAR, no tiene tesoros ocultos");
        }
        else
        {
        for(int i=0; i<anteriorP.hiddenTreasures.size();i++)
        {
            aux = anteriorP.hiddenTreasures.get(i);
            bonus = aux.getBonus();
            
            if(bonus>mayor)
            {
                mayor=bonus;
                maximo=aux;                
            }
        }
        
        Treasure tesorito = maximo;
        //anteriorP.hiddenTreasures.remove(maximo);
        
        //SI ES CULTIST
        if(maximo.getType()==TreasureKind.ONEHAND && anteriorP.getClass()==currentPlayer.getClass())
        {
            Random rnd = new Random();
            int nextIndex;
            
            do {
               nextIndex = rnd.nextInt(anteriorP.hiddenTreasures.size());
               tesorito = anteriorP.hiddenTreasures.get(nextIndex);
            } while (anteriorP.hiddenTreasures.get(nextIndex).getType()==TreasureKind.ONEHAND);    
        }
        if(!anteriorP.hiddenTreasures.isEmpty())
            {
                boolean iguales=false;
                
                for(int i=0; i<currentPlayer.visibleTreasures.size();i++)
                {
                    if(currentPlayer.visibleTreasures.get(i).getType()==tesorito.getType())
                    {
                        iguales=true;
                    }
                }
                if(!iguales)
                {
                    currentPlayer.visibleTreasures.add(tesorito);
                    anteriorP.hiddenTreasures.remove(tesorito); 
                }
               // else
                    
                //.usedTreasure.add(tesorito);
            }
        }
        
    }
    private Player nextPlayer()
    {

        int nextIndex;
        Player nextPlayer;

        //Obtenemos el numero total de jugadores
        int totalPlayers = this.players.size();

        //Si no está definido el jugador actual es porque es la primera vez
        if (this.currentPlayer == null) {

            //Creamos un objeto Random
            Random rnd = new Random();

            //Obtenemos un numero aleatorio con tope el índice maximo del 
            //numero de jugadores
            nextIndex = rnd.nextInt(totalPlayers);

        } else {

            //Obtenemos el índice del jugador actual
            int currentPlayerIndex = this.players.indexOf(this.currentPlayer);

            if (currentPlayerIndex == totalPlayers - 1) {
                //Si es el último seleccionamos el primero
                nextIndex = 0;

            } else {
                //En caso contrario seleccionamos el siguiente
                nextIndex = currentPlayerIndex + 1;
            }

        }

        //Obtenemos el jugador correspondiente al índice aleatorio
        nextPlayer = this.players.get(nextIndex);

        //Establecemos el siguiente jugador
        this.currentPlayer = nextPlayer;

        return this.currentPlayer;
    }
    
    
    public boolean nextTurnAllowed()
    {
        if(currentPlayer != null)
            return currentPlayer.validState();
        else
            return true;
    }
    private void setEnemies()
    {
        int rand;
        Player randomP;
        for(int i = 0; i < players.size(); i++)
        {
            
            rand = (int) (Math.random() * players.size());
            while(rand == i)
                rand = (int) (Math.random() * players.size());

            randomP = players.get(rand);
            players.get(i).setEnemy(randomP);

        }
    }
    
    public static Napakalaki getInstance()
    {
        if(instance == null)
            instance = new Napakalaki();
        return instance;
    }
    
    public CombatResult developCombat()
    {
        CombatResult combate = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        if(combate == CombatResult.LOSEANDCONVERT)
        {
            Cultist cultist = dealer.nexCultist();
            CultistPlayer jugador = new CultistPlayer(currentPlayer, cultist);
            int pos = players.indexOf(currentPlayer);
            for(Player player : players)
            {
                if(player.getEnemy() == currentPlayer)
                {
                    player.setEnemy(jugador);
                }
                
                currentPlayer = jugador;
                players.set(pos, jugador);
            }
        }
        return combate;
    }
    
    public void discardVisibleTreasures(ArrayList <Treasure> treasures)
    {
        for (Treasure treasure : treasures) {
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList <Treasure> treasures)
    {
        for(Treasure treasure : treasures)
        {
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
        
    }
    
    public void makeTreasuresVisible(ArrayList <Treasure> treasures)
    {
        for(Treasure treasure : treasures)
        {
            currentPlayer.makeTreasureVisible(treasure);
        }
    }
    
    public void initGame(ArrayList<String> names) {

        this.initPlayers(names); 
        this.setEnemies();
        dealer.initCards(); 

        this.nextTurn(); 


    }
    
    public Player getCurrentPlayer()
    {
        return currentPlayer;
       
    }
    
    public Monster getCurrentMonster()
    {
        return currentMonster;
    }
    
    public boolean nextTurn()
    {
        boolean estado = nextTurnAllowed();
        if(estado)
        {
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean muerte = currentPlayer.isDead();
            if(muerte)
            {
                currentPlayer.initTreasures();
            }
        }
        return estado;
    }
    
    public boolean endOfGame(CombatResult result)
    {
        return result == CombatResult.WINGAME;
    }
    

}
