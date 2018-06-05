package restServ.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @Autowired
    private StringService serv;

    @RequestMapping("/string/concat")
    public String concat(@RequestParam String a, @RequestParam String b){
        return serv.concat(a,b);
    }

    @RequestMapping("/string/changePos")
    public String change(@RequestParam String a, @RequestParam String b){
        return serv.changePos(a,b);
    }
    @RequestMapping("/string/reverse")
    public String reverse(@RequestParam String a){
        return serv.reverse(a);
    }

}
