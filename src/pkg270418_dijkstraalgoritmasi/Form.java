package pkg270418_dijkstraalgoritmasi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Form extends javax.swing.JFrame {

 
    public Form() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    
    
    public void optimizeDugumler(node[] dugumler){
        int i=0;
        for (node dugum:dugumler) {
            System.out.println("Dugumun Adı : "+dugumler[i].getDugumIsmi()+" Dugumun baglantı Sayısı "+dugumler[i].nextNodeListe.size()+"  ");
            i++;
        }
        
        for (node dugum:dugumler) {
            System.out.println("Uzerinde Oldugum Dugumunun Adı : "+dugum.getDugumIsmi());
            for (int j = 0; j < dugum.nextNodeListe.size(); j++) {
                System.out.println(" ----> Gittigi Dugumun Adı : "+dugum.nextNodeListe.get(j).getDugumIsmi()+" Maaliyet "+dugum.nextNodeListe_Maliyet.get(j)+"  ");
            }
        }
        
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillRect(10, 70, 50, 50);
        g.fillRect(100, 70, 50, 50);
        
        
        g.fillArc(100,150,50,50,5,360);
    }
    
    
    public void listeyiAl(ArrayList<String> log){
        
        node[] dugumler=dugumNesnesiniGetir(log);
        
        String[] ilkparca,ikinciparca;
        
        String[] anaDugumler=new String[log.size()];
        
        String[] gidilenDugum=new String[log.size()];
        
        Integer[] maliyet=new Integer[log.size()];
        
        for (int i = 0; i < log.size(); i++) {    
            //A,B:10
            ilkparca = log.get(i).toString().split(",");
            //ilkparca[0] uzerinde bulundugumuz dugum ismi
            ikinciparca = ilkparca[1].split(":");
            // ikinciparca[0] gidiilcek dugum ismi
            // ikiciparca[1] maaliyet
            
            anaDugumler[i]=ilkparca[0];
            gidilenDugum[i]=ikinciparca[0];
            maliyet[i]=Integer.parseInt(ikinciparca[1]);
            /*
            if(isimIleNesneGetir(ilkparca[0],dugumler).nextNodeListe.size()==0){
                isimIleNesneGetir(ilkparca[0],dugumler).nextNodeListe.add(isimIleNesneGetir(ikiciparca[0],dugumler));
            }else{
                isimIleNesneGetir(ilkparca[0],dugumler).nextNodeListe.clear();
                isimIleNesneGetir(ilkparca[0],dugumler).nextNodeListe.add(isimIleNesneGetir(ikiciparca[0],dugumler));
            } */
        }

            int enkucuk=999+1,tempj=-1,kontrol=-1;;
            for (int i = 0; i < gidilenDugum.length; i++) {
                tempj=i;
              for (int j = 0; j < gidilenDugum.length; j++) {
                    if (gidilenDugum[i].equals(gidilenDugum[j])) {
                        for (int k =i-1 ; k >=0; k--) {
                            if (gidilenDugum[i].equals(gidilenDugum[k])) {
                                kontrol=0;
                                break;
                            }
                        }
                        
                        if(kontrol==-1){
                            if (maliyet[j]<enkucuk) {
                                enkucuk=maliyet[j];
                                tempj=j;
                                System.out.println(i+" deger : "+enkucuk);
                            }
                        }
                        kontrol=-1;
                    }
                }
                
            
                
                if (kontrol==-1 && enkucuk<999+1) {
                    isimIleNesneGetir(anaDugumler[tempj],dugumler).nextNodeListe.add(isimIleNesneGetir(gidilenDugum[tempj],dugumler));
                    isimIleNesneGetir(anaDugumler[tempj],dugumler).nextNodeListe_Maliyet.add(maliyet[tempj]);
                    System.out.println(i+" Secilen : "+enkucuk);
                }
                
            kontrol=-1;
            
            enkucuk=999+1;
            tempj=-1;
            
            }
            
            
            
            
  
            
            optimizeDugumler(dugumler);
            
            
            
            
    }
    public node isimIleNesneGetir(String aranan,node[] dugumler){
        for (int i = 0; i < dugumler.length; i++) {
            if (dugumler[i].getDugumIsmi().equals(aranan)) {
                return dugumler[i];
            }
        }
        return new node("Error");
    }
    public node[] dugumNesnesiniGetir(ArrayList<String> log){
        ArrayList<String> dugumIsimleri = tumDugumlerIsmi(log);
        
        node[] dugumler = new node[dugumIsimleri.size()];
        for (int i = 0; i < dugumler.length; i++) {
            dugumler[i]=new node(dugumIsimleri.get(i));
        }
        return dugumler;
    }
    public ArrayList<String> tumDugumlerIsmi(ArrayList<String> log){
        ArrayList<String> tumDugumler=new ArrayList<String>();
        for (String ifade:log) {
            for (int i = 0; i < ifade.length(); i++) {
                char harf=ifade.toCharArray()[i];
                if (harf==',' || harf==':') {
                                   
                }else{
                    if (!isNumeric(harf)) {
                        tumDugumler.add(harf+"");
                    }
                }
            }
        }
        return tumDugumlerIsmiSadelestir(tumDugumler);
    }
    public ArrayList<String> tumDugumlerIsmiSadelestir(ArrayList<String> log){
        ArrayList<String> dugumler_sade=new ArrayList<>();
        int tempSayac=0;
        for (int i = 0; i < log.size(); i++) {
            if(!dugumler_sade.contains(log.get(i))){
                dugumler_sade.add(log.get(i));
            }
        }
        return dugumler_sade;
    }
    public static boolean isNumeric(char str)  
    {  
  try  
  {  
    int d = Integer.parseInt(str+"");
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
