package restServ.hello;

import org.springframework.stereotype.Service;

@Service
public class StringService {
    public String concat(String a, String b){
        return a + " " + b;
    }

    public String changePos(String a, String b){
        return b + " " + a;
    }

    public String reverse(String a){
        StringBuilder input = new StringBuilder();

        input.append(a);
        input = input.reverse();
        return input.toString();
    }

}
