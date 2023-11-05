package homework.onlineStore.models;

import homework.onlineStore.enums.UserType;

import java.util.Objects;

public class User {
    private String ID;
    private String name;
    private String email;
    private String password;
    private UserType type;

    public User() {
    }

    public User(String ID, String name, String email, String password, UserType type) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getID(), user.getID()) && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && getType() == user.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getEmail(), getPassword(), getType());
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
