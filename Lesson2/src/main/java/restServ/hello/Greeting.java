package restServ.hello;

import org.apache.commons.codec.binary.Hex;
import restServ.security.Uuid;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class Greeting {
    static List<Greeting> personList = new ArrayList<Greeting>();

    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String pass;
    private Uuid uuid;



    public Greeting(){}

    public Greeting(long id, String firstName, String lastName, String login, String pass){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        setPass(pass);
        personList.add(this);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPass(String pass){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update((pass).getBytes(Charset.forName("UTF8")));
            byte[] resultByte = messageDigest.digest();
            String result = new String(Hex.encodeHex(resultByte));
            this.pass = result;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid");
        }
    }

    public void setUuid(Uuid uuid) {
        this.uuid = uuid;
    }

    public long getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin(){
        return login;
    }

    public String getPass(){
        return pass;
    }

    public Uuid getUuid() {
        return uuid;
    }

    public boolean checkPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update((password).getBytes(Charset.forName("UTF8")));
            byte[] resultByte = messageDigest.digest();
            String result = new String(Hex.encodeHex(resultByte));
            if (result.equals(this.pass))
                return true;
            else
                return false;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid");
        }
        return false;
    }


    public void updateUUID(){
        this.uuid = new Uuid();
    }

}
