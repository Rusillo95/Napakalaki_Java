/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Rusillo
 */
public class CardDealer {

    private static CardDealer instance = null;
    
    
// El constructor privado asegura que no se puede instanciar desde otras clases
private CardDealer() { }

public static CardDealer getInstance() {

        if (instance == null) {
            instance = new CardDealer();
        }
        return instance;
}
private ArrayList<Monster> unusedMonsters;
private ArrayList<Monster> usedMonsters;
private ArrayList<Treasure> unusedTreasures;
public ArrayList<Treasure> usedTreasures;
private ArrayList<Cultist> unusedCultists;

 private void initTreasureCardDeck()
    {
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        
        unusedTreasures.add(new Treasure("Si mi amo",4,TreasureKind.HELMET, "01"));
        unusedTreasures.add(new Treasure("<html><body>Botas de<br>investigacion</body></html>",3,TreasureKind.SHOES, "02"));
        unusedTreasures.add(new Treasure("<html><body>Capucha de<br>Cthulhu</body></html>",3,TreasureKind.HELMET,"03"));
        unusedTreasures.add(new Treasure("A Prueba de babas",2,TreasureKind.ARMOR, "04"));
        unusedTreasures.add(new Treasure("<html><body>Botas de Lluvia acida</body></html>",1,TreasureKind.BOTHHANDS, "05"));
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET, "06"));
        unusedTreasures.add(new Treasure("<html><body>Ametrralladora Thompson</body></html>",4,TreasureKind.BOTHHANDS, "07"));
        unusedTreasures.add(new Treasure("<html><body>Camiseta de la UGR</body></html>",1,TreasureKind.ARMOR, "08"));
        unusedTreasures.add(new Treasure("<html><body>Clavo de<br>rail ferroviario</body></html>",3,TreasureKind.ONEHAND, "09"));
        unusedTreasures.add(new Treasure("<html><body>Cuchicllo de<br>sushi arcano</body></html>",2,TreasureKind.ONEHAND, "10"));
        unusedTreasures.add(new Treasure("Fez Alópodo",3,TreasureKind.HELMET, "11"));
        unusedTreasures.add(new Treasure("<html><body>Hacha<br>prehistórica</body></html>",2,TreasureKind.ONEHAND, "12"));
        unusedTreasures.add(new Treasure("<html><body>El aparato<br>de Pr. Tesla</body></html>",4,TreasureKind.ARMOR, "13"));
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS, "14"));
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND, "15"));
        unusedTreasures.add(new Treasure("<html><body>Escopeta<br>de 3 cañones</body></html>",4,TreasureKind.BOTHHANDS, "16"));
        unusedTreasures.add(new Treasure("Garabato mistico",2,TreasureKind.ONEHAND, "17"));
        unusedTreasures.add(new Treasure("<html><body>La rebaca<br>metalica</body></html>",2,TreasureKind.ARMOR, "18"));
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS, "19"));
        unusedTreasures.add(new Treasure("Necro-comicon",4,TreasureKind.ONEHAND, "20"));
        unusedTreasures.add(new Treasure("Necronomicon",5,TreasureKind.BOTHHANDS, "21"));
        unusedTreasures.add(new Treasure("<html><body>Linterna a<br>2 manos</body></html>",3,TreasureKind.BOTHHANDS, "22"));
        unusedTreasures.add(new Treasure("<html><body>Necro-gnomicon</body></html>",2,TreasureKind.ONEHAND, "23"));
        unusedTreasures.add(new Treasure("<html><body>Necrotelecom</body></html>",2,TreasureKind.HELMET, "24"));
        unusedTreasures.add(new Treasure("<html><body>Mazo de<br>los antiguos</body></html>",3,TreasureKind.ONEHAND, "25"));
        unusedTreasures.add(new Treasure("Necro-playboycon",3,TreasureKind.ONEHAND, "26"));
        unusedTreasures.add(new Treasure("<html><body>Porra<br>preternatural</body></html>",2,TreasureKind.ONEHAND, "27"));
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS, "28"));
        unusedTreasures.add(new Treasure("<html><body>Varita de<br>atizamiento</body></html>",3,TreasureKind.ONEHAND, "29"));
        unusedTreasures.add(new Treasure("<html><body>Tentaculo de<br>pega</body></html>",2,TreasureKind.HELMET, "30"));
        unusedTreasures.add(new Treasure("<html><body>Zapato<br>deja-amigos</body></html>",1,TreasureKind.SHOES, "31"));
    }

    private void initMonsterCardDeck()
    { 
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        SpecificBC BCspecific;
        DeathBC deathBC;
        BadConsequence bc = null;               // objeto bad consequence
        Prize pr = null;                        // objeto prize

        // 1 - 3 Byakhees de bonanza
        BCspecific = new SpecificBC("Pierdes tu armadura visible y otra oculta",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        pr = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, BCspecific, pr, "M01"));

        // 2 - Chibithulhu
        BCspecific = new SpecificBC("Embobados con el lindo primigenio te descartas tu casco visible",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                                new ArrayList());
        pr = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, BCspecific, pr, "M02"));

        // 3 - El sopor de Dunwich
        BCspecific = new SpecificBC("El primordial bostezo contagioso.Pierdes el calzado visible",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                                new ArrayList());
        pr = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, BCspecific, pr, "M03"));

        // 4 - Angeles de la noche ibencenca
        
        BCspecific = new SpecificBC("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        pr = new Prize(4,1);
        unusedMonsters.add(new Monster("Angeles de la noche ibencenca", 14, BCspecific, pr, "M04"));

        // 5 - El gorron en el umbral
        bc = new NumericBC("Pierdes todos tus tesoros visibles",
                                0,
                                BadConsequence.MAXTREASURES,
                                0);
        pr = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorron en el umbral",10,bc,pr, "M05"));

        // 6 - H.P.Munchcraft
        BCspecific = new SpecificBC("Pierdes la armadura visible",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                new ArrayList());
        pr = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P.Munchcraft",6,BCspecific,pr, "M06"));

        // 7 - Bichgooth
        BCspecific = new SpecificBC("Sientes bichos bajo la ropa. Descarta la armadura visible",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                new ArrayList());
        pr = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2,BCspecific,pr, "M07"));

        // 8 - El rey de rosa
        NumericBC badC = new NumericBC("Pierdes 5 niveles y 3 tesoros visibles",
                                5,
                                3,
                                0);
        pr = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, bc, pr , "M08"));

        // 9 - La que redacta en las tinieblas

        bc = new NumericBC("Toses los pulmones y pierdes dos niveles",
                                2,
                                0,
                                0);
        pr = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,bc,pr, "M09"));

        // 10 - Los hondos

        deathBC = new DeathBC("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.",
                                true);
        pr = new Prize(2,1);
        unusedMonsters.add(new Monster("Los Hondos",8,deathBC,pr, "M10"));

        // 11 - Semillas Cthulhu
        bc = new NumericBC("Pierdes 2 niveles y 2 tesoros ocultos",
                                2,
                                0,
                                2);
        pr = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu",4,bc,pr, "M11"));


        // 12 - Dameargo
        BCspecific = new SpecificBC("Te intentas escapar. Pierdes una mano visible",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                                new ArrayList());
        pr = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, BCspecific, pr, "M12"));

        // 13 - Pollipólipo volante
        bc = new NumericBC("Da mucho asquito. Pierdes 3 niveles.",
                                3,
                                0,
                                0);
        pr = new Prize(1, 1);
        unusedMonsters.add(new Monster("Polipólipo volante.", 3, bc, pr, "M13"));

        // 14 - Yskhtihyssg-Goth
        deathBC = new DeathBC("No le hace gracia que pronuncien mal su nombre. Estas muerto.",
                                true);
        pr = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, deathBC, pr, "M14"));

        // 15 - La familia feliz

        deathBC = new DeathBC("La familia te atrapa. Estas muerto",
                                true);
        pr = new Prize(4,1);
        unusedMonsters.add(new Monster("La familia feliz",1,deathBC,pr, "M15"));


        // 16 - Roboggoth
        BCspecific = new SpecificBC("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro BothHands",
                                2,
                                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                                new ArrayList());
        pr = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth",8,BCspecific,pr, "M16"));


        // 17 - El espia
        BCspecific = new SpecificBC("Te asusta en la noche. Pierdes tu casco visible",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                                new ArrayList());
        pr = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia",5,BCspecific,pr, "M17"));


        // 18 - El Lenguas
        bc = new NumericBC("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",
                                2,
                                5,
                                0);
        pr = new Prize(1,1);
        unusedMonsters.add(new Monster("El lenguas",20,bc,pr, "M18"));


        // 19 - Bicefalo
        
        ArrayList tvisible = new ArrayList(Arrays.asList(TreasureKind.ONEHAND));
        tvisible.add(TreasureKind.ONEHAND);
        tvisible.add(TreasureKind.BOTHHANDS);
        ArrayList thidden = new ArrayList();
        BCspecific = new SpecificBC("Te faltan manos para tanta cabeza.Pierdes 3 niveles y tus tesoros visibles de las manos",
                                3,
                                tvisible,
                                thidden);
        pr = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicefalo",19,BCspecific,pr,  "M19"));
        
        
        //****************//
        //cultist monsters//
        //****************//
        
        //20 - el mal indecible impronunciable
        BCspecific = new SpecificBC("Pierdes 1 mano visible",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                                new ArrayList());
        pr = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronuniable", 10, BCspecific, pr, "C0"));
        
        //21 - testigos oculares
        bc = new NumericBC("Pierdes tus tesoros visibles. Jajaja",
                                0,
                                BadConsequence.MAXTREASURES,
                                0);
        pr = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, bc, pr, "C1"));
        
        //22 el gran cthulhu
        deathBC = new DeathBC("Hoy no es tu dia de suerte, Mueres",
                                true);
        pr = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, deathBC, pr, "C2"));
        
        //23 - Serpiente Politico
        bc = new NumericBC("Tu gobierno te recorta 2 niveles",
                                2,
                                0,
                                0);
        pr = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, bc, pr, "C3"));  
        
        //24 - felpuggoth
        BCspecific = new SpecificBC("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",
                                0,
                                new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)),
                                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)));
        pr = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, BCspecific, pr, "C4"));
        
        //25 - shoggoth
        bc = new NumericBC("Pierdes 2 niveles",
                                2,
                                0,
                                0);
        pr = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, bc, pr, "C5"));      
        
        //26 - Lolitagooth
        bc = new NumericBC("Pintalabios negro. Pierdes 2 niveles.",
                                2,
                                0,
                                0);
        pr = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bc, pr, "C6"));   
                
    }




private void shuffleTreasures()
{
    Collections.shuffle(this.unusedTreasures);
}

private void shuffleMonsters()
{
    Collections.shuffle(this.unusedMonsters);
}

private void shuffleCultist()
{
    Collections.shuffle(unusedCultists);
}

private void initCultistCardDeck()
{
    unusedCultists = new ArrayList();
    Cultist sectario;
    
    sectario = new Cultist("Sectario +1 por cada sectario en juego. No puedes dejar de"
                + " ser sectario", 1);
    unusedCultists.add(sectario);
    
    sectario = new Cultist("Sectario +2 por cada sectario en juego. No puedes dejar" +
            " de ser sectario", 2);
    unusedCultists.add(sectario);
    
    sectario = new Cultist("Sectario +1 por cada sectario en juego. No puedes dejar"
            +" de ser sectario", 1);
    unusedCultists.add(sectario);
    
    sectario = new Cultist("Sectario +2 por cada sectario en juego. No puedes dejar "
            +"de ser sectario",2);
    unusedCultists.add(sectario);
    
    sectario = new Cultist("Sectario +1 por cada sectario en juego" 
    +". No puedes dejar de ser sectario", 1);
    unusedCultists.add(sectario);
    
    sectario = new Cultist("Sectario +1 por cada sectario en juego" 
    +". No puedes dejar de ser sectario", 1);
    unusedCultists.add(sectario);
}

public Cultist nexCultist()
{
            //Si hay cartas 
        if (this.unusedCultists.isEmpty()) {
            
            //Inicializamos de nuevo la baraja
            this.initCultistCardDeck();
            
            //Las barajamos
            this.shuffleCultist();
            
        }
        
        //Obtengo la primera carta del mazo
        Cultist m = this.unusedCultists.get(0);
        
        
        //La eliminamos del mazo
        this.unusedCultists.remove(m);
        
        //Devolvemos la carta
        return m;
        
    
}
public Treasure nextTreasure()
{
    //comprobamos si esta vacio
    if(unusedTreasures.isEmpty())
    {
        //pasamos las usadas a las no usadas
        unusedTreasures = usedTreasures;
        //limpiamos las usadas
        usedTreasures = new ArrayList();
        //barajamos el mazo
        shuffleTreasures();
    }
    
    //1 carta
    Treasure actual = unusedTreasures.get(0);
    //la elimino
    unusedTreasures.remove(0);
    //la añado a usadas
    usedTreasures.add(actual);
    return actual;
}
   
    public Monster nextMonster() {
        
        //Comprobamos si tenemos cartas en el mazo
        if (this.unusedMonsters.isEmpty()) {
            
            //Recorremos las cartas descartadas
            for (Monster m: this.usedMonsters) {
                //Las agregamos al mazo sin usar
                this.unusedMonsters.add(m);
            }
            
            //Las barajamos
            this.shuffleMonsters();
            
            //Limpiamos el mazo de descartes
            this.usedMonsters.clear();
        
        }
        
        //Obtengo la primera carta del mazo
        Monster m = this.unusedMonsters.get(0);
        
        //La agregamos al mazo de descartes
        this.usedMonsters.add(m);
        
        //La eliminamos del mazo
        this.unusedMonsters.remove(m);
        
        //Devolvemos la carta
        return m;
        
    }

public void giveTreasureBack(Treasure t)
{
    usedTreasures.add(t);
}

public void giveMonsterBack(Monster M)
{
    usedMonsters.add(M);
}

public void initCards() {
        
    this.initTreasureCardDeck(); //1.2.1
    this.shuffleTreasures();
    this.initCultistCardDeck();
    this.shuffleCultist();
    this.initMonsterCardDeck();  //1.2.2
    this.shuffleMonsters();
    

    }

        
}
//CAMBIADA VISIBILIDAD DE USEDTREASURE