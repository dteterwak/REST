package client;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class Application {
    public static void main(String[] args) {


        RestTemplate restTemplate = new RestTemplate();
        String login = "log";
        String pass = "123456";

        Uuid myUUID = restTemplate.postForObject("http://localhost:8080/login?login="+login, pass, Uuid.class);

        HttpEntity<Greeting> request = new HttpEntity<Greeting>(new Greeting(7, "John", "Brie", "JB", "jbjb"));
        restTemplate.postForObject("http://localhost:8080/addperson", request, Greeting.class);

        Greeting person = restTemplate.postForObject("http://localhost:8080/2/getPerson", myUUID, Greeting.class);
        System.out.println(person.getFirstName() +" "+ person.getLastName() +" "+ person.getLogin() +" "+ person.getUuid() +" "+ person.getPass());

        Greeting person2 = restTemplate.postForObject("http://localhost:8080/1/getPerson", myUUID, Greeting.class);
        System.out.println(person2.getFirstName() +" "+ person2.getLastName() +" "+ person2.getLogin() +" "+ person2.getUuid() +" "+ person2.getPass());

    }
}
