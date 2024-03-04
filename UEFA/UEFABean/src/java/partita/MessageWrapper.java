/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partita;

import java.io.Serializable;


public class MessageWrapper implements Serializable{
    private int id;
    private int goal;
    private String squadra;

    public MessageWrapper(int id, int goal, String squadra) {
        this.id = id;
        this.goal = goal;
        this.squadra = squadra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public String getSquadra() {
        return squadra;
    }

    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }
    
    
}
