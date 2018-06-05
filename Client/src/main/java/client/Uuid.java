package client;

import java.sql.Timestamp;
import java.util.UUID;

public class Uuid {
    private UUID hash;
    private Timestamp date;

    public UUID getHash(){
        return hash;
    }

    public Timestamp getDate(){
        return date;
    }

    public void setHash(UUID hash){
        this.hash = hash;
    }

    public void setDate(Timestamp date){
        this.date = date;
    }

    public Uuid(){
        hash = UUID.randomUUID();
        date = new Timestamp(System.currentTimeMillis());
    }
}
