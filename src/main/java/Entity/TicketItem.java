/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Klein
 */
public class TicketItem {
    
    int id;
    String description_item;
    String date;
    String atendant;
    int ticket_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription_item() {
        return description_item;
    }

    public void setDescription_item(String description_item) {
        this.description_item = description_item;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAtendant() {
        return atendant;
    }

    public void setAtendant(String atendant) {
        this.atendant = atendant;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }
    
    
    
}
