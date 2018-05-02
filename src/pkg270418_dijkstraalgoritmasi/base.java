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
        
        ArrayList<node> tumDugumler =new ArrayList<node>();
        tumDugumler.add(A);tumDugumler.add(B);tumDugumler.add(C);tumDugumler.add(D);tumDugumler.add(E);
        
        enkısa(A,tumDugumler);
    }      
      void enkısa(node start,ArrayList<node> liste){
         //Degişken Tanımlama Baslangıc
         int i=0,Tempindex=0,enKucuk=999+1;;
         ArrayList<String> log = new ArrayList<String>();
         String[] gezilen=new String[liste.size()],gezilmeyen=new String[liste.size()],tumDugumler=new String[liste.size()],dugumKisaDizisi_Isim=new String[liste.size()];
         node[] dugumKisaDizisi=new node[liste.size()];
         Integer[] kisaMaliyet=new Integer[liste.size()];
         //Degişken Tanımlama Son
         
         for(node tempDugum:liste){
             if(start.getDugumIsmi()!=tempDugum.getDugumIsmi()){
                 kisaMaliyet[i]=999;
             }
             else{
                 kisaMaliyet[i]=0;
             }
             gezilmeyen[i]=tempDugum.getDugumIsmi();
             tumDugumler[i]=tempDugum.getDugumIsmi();
             gezilen[i]="Null";
             i++;
         }
         // Hesap  Baslangıc
         
        dugumKisaDizisi[0]=new node("A1");
        dugumKisaDizisi[1]=new node("B1");
        dugumKisaDizisi[2]=new node("C1");
        dugumKisaDizisi[3]=new node("D1");
        dugumKisaDizisi[4]=new node("E1");
        
        dugumKisaDizisi_Isim[0]="A";
         for (int j = 0; j < liste.size(); j++) {
             
             for(node gidilen:start.nextNodeListe){
		if(kisaMaliyet[result(gidilen.getDugumIsmi(),tumDugumler)]>start.nextNodeListe_Maliyet.get(Tempindex)+kisaMaliyet[result(start.getDugumIsmi(),tumDugumler)]){
                    
                kisaMaliyet[result(gidilen.getDugumIsmi(),tumDugumler)]=start.nextNodeListe_Maliyet.get(Tempindex)+kisaMaliyet[result(start.getDugumIsmi(),tumDugumler)];
                
                log.add(start.getDugumIsmi()+","+gidilen.getDugumIsmi()+":"+start.nextNodeListe_Maliyet.get(Tempindex));
		}
		Tempindex++;
            }
             gezilen[result(start.getDugumIsmi(),tumDugumler)]=start.getDugumIsmi();
             gezilmeyen[result(start.getDugumIsmi(),tumDugumler)]="Null"; 
             
             
             for(int z=0;z<liste.size();z++){     
                if(gezilmeyen[z]!="Null"){
                    if(kisaMaliyet[result(gezilmeyen[z],tumDugumler)]<enKucuk){
                        enKucuk=kisaMaliyet[result(gezilmeyen[z],tumDugumler)];
                        start=liste.get(z);
                    }
                }
            }
             enKucuk=1000;
             Tempindex=0;
         }
         // Hesap Bitis
         
        Form nesne= new Form();
        nesne.setVisible(true);
        nesne.listeyiAl(log);
     }
      
     int result(String aranan,String[] tumDugumler){
        for (int i = 0; i < tumDugumler.length; i++)
            if (tumDugumler[i].equals(aranan))
                return i;
        return -1;
    }
}
