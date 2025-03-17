package org.example;

public abstract class Account {
    private String Username;
    private  String Password;
    private AccountStatus status;
    private Person person;

    public Account(String username, String password, Person person, AccountStatus status){
        this.Username = username;
        this.Password = password;
        this.person = person;
        this.status = status;
    }

    public boolean resetPassword(){
        System.out.println("Password request sent to" + Username);
        return true;
    }

    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
    public Person getPerson() {
        return person;
    }
    public AccountStatus getStatus() {
        return status;
    }
    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public void setPassword(String password) {
        Password = password;
    }

}
