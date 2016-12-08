/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package napasept;

//import java.util.ArrayList;
//import java.util.Arrays;

/**
 *
 * @author Rusillo
 *//*
public class PruebaNapakalaki {
        // TODO code application logic here
    
        
        public static void main(String[] args) {
        //Array list de monstruos
        ArrayList<Monster> monstruos = new ArrayList();
        
        //El rey de Rosa
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y tres tesoros visibles",5,3,0);
        Prize price = new Prize(4,2);
        monstruos.add(new Monster("El rey de Rosa", 13, badConsequence, price));
        
        //Semillas Cthulhu
        badConsequence= new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        price = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu",4,badConsequence,price));
        
        //Angeles de la noche ibicenca
        badConsequence= new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        price = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca",14,badConsequence,price));
        
        //Bithgooth
        badConsequence= new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        price = new Prize(1,1);
        monstruos.add(new Monster("Bitchgooth",2,badConsequence,price));
       
        //Familia Feliz
        badConsequence= new BadConsequence("La familia te atrapa. Estas muerto.",true);
        price = new Prize(4,1);
        monstruos.add(new Monster("Familia Feliz",1,badConsequence,price));
        
        //los Hondos
        badConsequence= new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.",true);
        price= new Prize(2,1);
        monstruos.add(new Monster("Los hondos",1,badConsequence,price));
        
        //Dameargo
        badConsequence= new BadConsequence("Te intentas escaquear,pierdes una mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        price = new Prize(2,1);
        monstruos.add(new Monster("Dameargo",1,badConsequence,price));
        
        //Pollipolipo volante
        badConsequence= new BadConsequence("Da mucho asquito.Pierdes 3 niveles",3,0,0);
        price = new Prize(1,1);
        monstruos.add(new Monster("Pollipólipo volante",3,badConsequence,price));
        
        //Yskhtihyssg-Goth
        badConsequence= new BadConsequence("No le hace gracia que pronuncien mal su nombre.Estás muerto.",true);
        price = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth",12,badConsequence,price));
        
        //Roboggoth
        badConsequence= new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y 1 tesoro 2 manos visibles",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
        price = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth",8,badConsequence,price));
        
        //El Espia
        badConsequence= new BadConsequence("Te asusta en la noche.Pierdes un casco visible.",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        price = new Prize(1,1);
        monstruos.add(new Monster("El Espía",5,badConsequence,price));
  
        //El Lenguas
        badConsequence= new BadConsequence("Menudo Susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        price = new Prize(1,1);
        monstruos.add(new Monster("El Lenguas",20,badConsequence,price));
        
        //Bicefalo
        badConsequence= new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
        price = new Prize(1,1);
        monstruos.add(new Monster("Bicéfalo",20,badConsequence,price));
        
        //Byakhees de Bonanza
        badConsequence= new BadConsequence("Pierdes tu armadura visible y otra oculta.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        price = new Prize(2,1);
        monstruos.add(new Monster("Byakhees de bonanza",8,badConsequence,price));
        
        //Chibithulhu
        badConsequence= new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        price = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu",2,badConsequence,price));
        
        //El sopor de Dunwich
        badConsequence= new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList());
        price = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich",2,badConsequence,price));
        
        //El gorron en el umbral
        badConsequence= new BadConsequence("Pierdes todos tus tesoros visibles",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.BOTHHANDS,TreasureKind.HELMET,TreasureKind.ONEHAND,TreasureKind.SHOES)),new ArrayList());
        price = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral",10,badConsequence,price));
        
        //H.P. Munchcraft
        badConsequence= new BadConsequence("Pierdes la Armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        price = new Prize(2,1);
        monstruos.add(new Monster("H.P.Munchcraft",6,badConsequence,price));
        
        //La que redacta en las tinieblas
        badConsequence= new BadConsequence("Toses los pulmones y pierdes 2 niveles.",2,0,0);
        price = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas",2,badConsequence,price));
        
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
       
        
        
}       //MAIN
}       //CLASE
*/