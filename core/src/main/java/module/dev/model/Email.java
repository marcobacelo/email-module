package module.dev.model;

import javax.persistence.*;

@Entity
@Table(name="email")
public class Email {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String subject;

    @Column
    private String address;

    @Column
    private String body;

    public Email (){}

    public Email(String subject, String address, String body) {
        this.setSubject(subject);
        this.setAddress(address);
        this.setBody(body);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
