package restServ.hello;

import org.springframework.stereotype.Service;
import restServ.security.Uuid;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleList {
    List<Greeting> pps = new ArrayList<Greeting>();

    public PeopleList(){
        pps.add(new Greeting(1,"Johnny","Kowalski", "log", "123456"));
        pps.add(new Greeting(2,"Bobby","Ross", "xd", "xd"));
        pps.add(new Greeting(3,"Dale","Cooper", "xd", "xd"));
        pps.add(new Greeting(4,"Audrey","Horne", "xd", "xd"));
        pps.add(new Greeting(5,"Laura","Palmer", "xd", "xd"));
        pps.add( new Greeting(6,"Pink","Freud", "xd", "xd"));
    }

    public Greeting getPerson(int id){
        for(Greeting g: pps){
            if(g.getId() == id){
                return g;
            }
        }
        return null;
    }

    public void addPerson(Greeting greeting){
        pps.add(greeting);
    }

    public void deletePerson(int user){
        for(Greeting g : pps){
            if(g.getId() == user){
                pps.remove(g);
                return;
            }
        }
    }

    public List<Greeting> getAllPersons(){
        return pps;
    }

    public boolean checkUUID(Uuid uuid){
        for(Greeting g : pps){
            if(g.getUuid().getHash().equals((uuid.getHash())))
                return true;
        }
        return false;
    }

    public Greeting checkLogin(String login, String pass){
        Greeting temp = null;
        for(Greeting g : pps){
            if(g.getLogin().equals(login)){
                temp = g;
                break;
            }
        }
        if(temp.checkPassword(pass))
            return temp;
        else
            return null;
    }



    /*public Greeting getPosition(int i){
        return pps.get(i);
    }*/


}
