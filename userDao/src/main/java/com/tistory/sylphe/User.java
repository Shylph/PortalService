package main.java.sylphe;

public class User {
    private Integer id;
    private String password;
    private String name;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
}
