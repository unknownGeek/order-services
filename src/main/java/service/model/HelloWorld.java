package service.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HelloWorld {

    private String message;


    public HelloWorld() {}


    public HelloWorld(String message) {
        super();
        this.message = "Hello " + message;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
