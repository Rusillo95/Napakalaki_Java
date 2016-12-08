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
public class NumericBC extends BadConsequence{
    
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
 public NumericBC(String text, int levels, int nVisible, int nHidden){
            super(text,levels);
            this.nVisibleTreasures=nVisible;
            this.nHiddenTreasures=nHidden;
}
 
public int getnVisibleTreasures(){
    return nVisibleTreasures;
}

public int getnHiddenTreasures(){
    return nHiddenTreasures;
}

@Override
public boolean isEmpty(){
    if(nVisibleTreasures==0 && nHiddenTreasures==0)
        return true;
    
    return false;
}

@Override
public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures>0)
            nVisibleTreasures--;
}

@Override
public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures>0)
            nHiddenTreasures--;
}

@Override
public NumericBC adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){   
    int visibles=0;
    int ocultos=0;

    //Si hay mas de 0 tesoros
        if(nVisibleTreasures > 0){ 
            //si tienes mas q el mal rollo se mantiene
            if(nVisibleTreasures > v.size()){
                visibles = v.size();
            }
            //si no se cambia a los que tienes
            else{
                visibles = nVisibleTreasures;
            }
        }
    //Si hay mas de 0 tesoros
        if(nHiddenTreasures > 0){
            //si tienes mas q el mal rollo se mantiene
            if(nHiddenTreasures > h.size()){
                ocultos = h.size();
            }
            //si no se cambia a los que tienes
            else{
                ocultos = nHiddenTreasures;
            }
        }

       NumericBC ResFinal = new NumericBC("", 0, visibles, ocultos);
       ResFinal.nHiddenTreasures=ocultos;
       ResFinal.nVisibleTreasures=visibles;
       return ResFinal;
        
    }

    public String toString(){
        return "\n Mal Rollo \n       Nombre Mal Rollo:" + this.text + "\n       Niveles:" + Integer.toString(this.levels) 
                + "\n       Tesoros Visibles:" + Integer.toString(this.nVisibleTreasures) +
                "\n       Tesoros No Visibles:" + Integer.toHexString(this.nHiddenTreasures);
                
    }
}
