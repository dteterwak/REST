package restServ.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restServ.security.Uuid;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private PeopleList peopleList = new PeopleList();

    @RequestMapping("/login")
    public Uuid getUUID(@RequestParam String login, @RequestBody String pass){
        Greeting g = peopleList.checkLogin(login, pass);
        if(g!=null){
            g.updateUUID();
            System.out.println(g.getUuid().getHash());
            return g.getUuid();
        }
        return null;
    }

    @RequestMapping("/{userId}/getPerson")
    public Greeting getPerson(@PathVariable("userId") int user, @RequestBody Uuid uuid)
    {
        if(System.currentTimeMillis() - uuid.getDate().getTime() < 120000 &&
                peopleList.checkUUID(uuid)){
           return peopleList.getPerson(user);
        }
        else{
            return null;
        }

    }

    @RequestMapping("/getAllPersons")
    public List<Greeting> getAllPersons()
    {
        return peopleList.getAllPersons();
    }

    @RequestMapping("/addperson")
    public void addPerson(@RequestBody @Valid Greeting greeting){
        peopleList.addPerson(greeting);
    }

    @RequestMapping("/{userId}/deleteperson")
    public @ResponseBody void deletePerson(@PathVariable("userId") int user)
    {
        peopleList.deletePerson(user);
        return;
    }


}
