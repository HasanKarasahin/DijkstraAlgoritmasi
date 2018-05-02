package pkg270418_dijkstraalgoritmasi;

import java.util.ArrayList;
/*
 * Tüm yollar -- Tamamlandı.
 * Bir şehirden tum sehirlere olan en kısa yol gösterilsin
 * Yazdgımız iki sehir arası en kısa yol ve gecilen dugumler gosterilsin
 */
public class base {
      public void baseFonksiyonu(){
        node A = new node("A");
        node B = new node("B");
        node C = new node("C");
        node D = new node("D");
        node E = new node("E");
        
        A.ekle(B, 10);
        A.ekle(C, 3);
        
        B.ekle(D,2);
        B.ekle(C,1);
        
        C.ekle(B,4);
        C.ekle(D,8);
        C.ekle(E,2);
        
        E.ekle(D,9);
        
        D.ekle(E,7);

        // Bu kod tum dugum yapısını listeler.
        
        ArrayList<node> tumDugumler =new ArrayList<node>();
        tumDugumler.add(A);tumDugumler.add(B);tumDugumler.add(C);tumDugumler.add(D);tumDugumler.add(E);
        //tumListeyiGöster(tumDugumler);
        
        enkısa(A,tumDugumler);
        
    }
      
     /*
       // ikiDugumArasiMaliyetler(A,D);
      }
      void tumListeyiGöster(ArrayList<node> tumDugumler){
             int i=0;
            for(node dugum:tumDugumler){
            System.out.println("Dugum İsmi : "+dugum.getDugumIsmi());
            for(node gittigiDugumler:dugum.gittigiDugumlerinListesi){
                    System.out.println(" --> Baglı Dugum İsmi : "+gittigiDugumler.getDugumIsmi());
                    System.out.println(" --> Baglı Dugumun Maaliyeti : "+dugum.gittigiDugumleriMaliyeti.get(i));
                    i++;
                }
                i=0;
            }
  */
      
     void enkısa(node start,ArrayList<node> liste){
         int i=0,Tempindex=0;
         
         ArrayList<String> log = new ArrayList<String>();
         
         String[] gezilen=new String[liste.size()];
         String[] gezilmeyen=new String[liste.size()];
         node[] dugumKisaDizisi=new node[liste.size()];
         
         String[] dugumKisaDizisi_Isim=new String[liste.size()];
  
         
         Integer[] kisaMaliyet=new Integer[liste.size()];
         
         for(node tempDugum:liste){
             if(start.getDugumIsmi()!=tempDugum.getDugumIsmi()){
                 kisaMaliyet[i]=999;
             }
             else{
                 kisaMaliyet[i]=0;
             }
             gezilmeyen[i]=tempDugum.getDugumIsmi();
             gezilen[i]="Null";
             i++;
         }
         // Hesap  Baslangıc
        int enKucuk=999+1;
        
        
        dugumKisaDizisi[0]=new node("A1");
        dugumKisaDizisi[1]=new node("B1");
        dugumKisaDizisi[2]=new node("C1");
        dugumKisaDizisi[3]=new node("D1");
        dugumKisaDizisi[4]=new node("E1");
        
        
        
        
        dugumKisaDizisi_Isim[0]="A";
         for (int j = 0; j < liste.size(); j++) {
             
             for(node gidilen:start.nextNodeListe){
		if(kisaMaliyet[result(gidilen.getDugumIsmi())]>start.nextNodeListe_Maliyet.get(Tempindex)+kisaMaliyet[result(start.getDugumIsmi())]){
                    
                kisaMaliyet[result(gidilen.getDugumIsmi())]=start.nextNodeListe_Maliyet.get(Tempindex)+kisaMaliyet[result(start.getDugumIsmi())];
                
                log.add(start.getDugumIsmi()+","+gidilen.getDugumIsmi()+":"+start.nextNodeListe_Maliyet.get(Tempindex));
                 
                
                
                
		}
		Tempindex++;
            }
             gezilen[result(start.getDugumIsmi())]=start.getDugumIsmi();
             gezilmeyen[result(start.getDugumIsmi())]="Null"; 
             
             int tempz=0;
             for(int z=0;z<liste.size();z++){     
                if(gezilmeyen[z]!="Null"){
                    if(kisaMaliyet[result(gezilmeyen[z])]<enKucuk){
                        enKucuk=kisaMaliyet[result(gezilmeyen[z])];
                        start=liste.get(z);
                        tempz=z;
                    }
                }
            }
           
             enKucuk=1000;
             Tempindex=0;
                //System.out.println((j+1)+" .Döngü -- >");
         
                //baslangictanItibarenAlinanYolGöster(kisaMaliyet);
                
                //System.out.println(" - Secilen Dugum "+enKucuk);
         }
         // Hesap Bitis
         
   
         
         
        Form nesne= new Form();
        nesne.setVisible(true);
        nesne.listeyiAl(log);
         
           
         /*
         for (int j = 0; j < dugumKisaDizisi.length; j++) {
             System.out.println("Ana Dugum : " + dugumKisaDizisi[j].getDugumIsmi());
             System.out.println("BuraKarısık  --> "+dugumKisaDizisi_Isim[j]);
             int temp=0;
             for (node dugum:dugumKisaDizisi[j].nextNodeListe) {
                 System.out.println("gidilen  --> "+dugum.getDugumIsmi());
                 System.out.println("gidilen --> "+dugumKisaDizisi[j].nextNodeListe_Maliyet.get(temp));
                 
                 
                 temp++;
             }
             temp=0;
         }*/
     }
     
     void gezilmeyenDugumleriGoster(String[] gezilmeyenDugumler){
         for (int j = 0; j < gezilmeyenDugumler.length; j++) {
              if(gezilmeyenDugumler[j]!="Null"){
                System.out.println("GezilmeyenDugumler-->"+gezilmeyenDugumler[j]);
              }
         }
     }
     void gezilenDugumleriGoster(String[] gezilenDugumler){
         for (int j = 0; j < gezilenDugumler.length; j++) {
              if(gezilenDugumler[j]!="Null"){
                System.out.println("gezilenDugumler-->"+gezilenDugumler[j]);
              }
         }
     }
     void baslangictanItibarenAlinanYolGöster(Integer[] gezilenDugumlerMaliyet){
           for (int j = 0; j < gezilenDugumlerMaliyet.length; j++) {
             System.out.println("GezilenDugumlerin Maliyeti-->"+gezilenDugumlerMaliyet[j]);
         }
     }
     int result(String dugumAdi){
         int deger=-1;
         if(dugumAdi=="A"){
             deger=0;
         }
         else if(dugumAdi=="B"){
             deger=1;
         }
         else if(dugumAdi=="C"){
             deger=2;
         }
         else if(dugumAdi=="D"){
             deger=3;
         }
         else if(dugumAdi=="E"){
             deger=4;
         }
         return deger;
     } 
}
