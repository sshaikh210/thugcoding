package app.models;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "Users")
public class User {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 100, message = "Username must at least 3 characters.")
    private String userName;
    @JsonIgnore
    @NotNull
    @Size(min = 3, max = 100, message = "Password must at least 3 characters.")
    private String password;
    
    @Transient
    private String confirmPassword;
    
    @Email(message = "Email address is not valid.")
    @NotNull
    private String email;
    @JsonIgnore
    private String token;
    private String role = "ROLE_USER";
    
    private String firstName;
    
    private String lastName;
    
    private String address;
    
    private String companyName;
    @JsonIgnore
    private String lastLogin;
    
    private String profilePicture;

    private boolean active = true;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonIgnore
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    @JsonIgnore
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    @JsonIgnore
    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Boolean isAdmin() {
        return this.role.equals("ROLE_ADMIN");
    }

    @JsonIgnore
    public Boolean isMatchingPasswords() {
        return this.password.equals(this.confirmPassword);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive(){
        return this.active;
    }
}