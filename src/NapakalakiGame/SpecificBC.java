/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Rusillo
 */
public class SpecificBC extends BadConsequence {
    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    Player player;
    
    public SpecificBC(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden)
    {
        super(text, levels);
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    
    /*************************************************************************/
    
    @Override
    public boolean isEmpty()
    {
        return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t)
    {
        specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t)
    {
        specificHiddenTreasures.remove(t.getType());
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
        //ARRAYS auxiliares para nuevo BC
        ArrayList<TreasureKind> auxSVisibleT = new ArrayList();
        ArrayList<TreasureKind> auxSHiddenT = new ArrayList();
        
        //BC auxiliar
        BadConsequence aux;

        //Inicializamos array
        ArrayList<TreasureKind> copiaV = new ArrayList();
       
        //recorremos los tesoros del mal rollo y los almacenamos en la copia
        for(Treasure t: v) copiaV.add(t.getType());
        //igual que antes pero con hidden
        ArrayList<TreasureKind> copiaH = new ArrayList();
        for(Treasure t: h) copiaH.add(t.getType());
        
        //Si no estan vacios
        if( !(specificVisibleTreasures.isEmpty() || specificHiddenTreasures.isEmpty()) )
        {
          /*
            //Recorre los tesoros que posee y coincide con el mal rollo los añade al auxiliar
            for(int i=0; i<copiaV.size(); i++)
            {
                for(int j=0; j<specificVisibleTreasures.size(); j++)           
                {
                 if(copiaV.get(i).equals(specificVisibleTreasures.get(j)))
                 {
                     auxSVisibleT.add(copiaV.get(i));
                     copiaV.remove(i);
                     
                }
                }
            }   
            for(int i=0; i<copiaH.size(); i++)
            {
                for(int j=0; i<specificHiddenTreasures.size(); i++)           
                {
                 if(copiaV.get(i).equals(specificHiddenTreasures.get(j)))
                 {
                     auxSHiddenT.add(copiaH.get(i));
                     copiaV.remove(i);
                     
                }
                }
            }
            */
                
            for(TreasureKind t: specificVisibleTreasures)
            {
                if(copiaV.contains(t)) 
                {
                    auxSVisibleT.add(t);
                    copiaV.remove(t);
                }
            }
            for(TreasureKind t: specificHiddenTreasures)
            {
                if(copiaH.contains(t))
                {
                    auxSHiddenT.add(t);
                    copiaH.remove(t);
                }
            }
            /*    if(copiaV.remove(t))
                    auxSVisibleT.add(t);
            //igual que antes
            for(TreasureKind t: specificHiddenTreasures)
                if(copiaH.remove(t))
                    auxSHiddenT.add(t);
            */
        }
        //BC ajustado con los tesoros que tiene el jugador disponibles
        aux = new SpecificBC(this.text, this.levels, auxSVisibleT, auxSHiddenT);   
        
        return aux;
    }
}

