package pkg270418_dijkstraalgoritmasi;
import java.util.*;
//Dügümlerin A dan B ye giderken ve B den A ya dönerken aynı maaliyet mantıgı ile kodlanmadı.
public class node {
   private String dugumIsim;
   
   ArrayList<node> nextNodeListe=new ArrayList<node>();
   ArrayList<Integer> nextNodeListe_Maliyet=new ArrayList<Integer>();
    
    public node(String dugumIsim){
        this.dugumIsim=dugumIsim;
    }
    public void ekle(node gittigi,int maliyeti){
        nextNodeListe.add(gittigi);
        nextNodeListe_Maliyet.add(maliyeti);
    }
    String getDugumIsmi(){
        return this.dugumIsim;
    }
}