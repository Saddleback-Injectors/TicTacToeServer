package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.Server.Authenticatable;

public interface User extends Authenticatable {
    String getUsername();
    String getFirstName();
    String getLastName();
    String getPassword();
    void setUsername(String username);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setPassword(String password);
}
