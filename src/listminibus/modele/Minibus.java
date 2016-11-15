/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listminibus.modele;

/**
 *
 * @author valentin
 */
public class Minibus {
    private int nominibus;
    private int capacite;
    
    public Minibus(int num,int cap){
        this.nominibus = num;
        this.capacite = cap;
    }
    
    public int getNoMinibus(){
        return this.nominibus;
    }
    
    public int getCapacite(){
        return this.capacite;
    }
    
    public void setNoMinibus(int num){
        this.nominibus = num;
    }
    
    public void setCapacite(int cap){
        this.capacite = cap;
    }
}
