package org.example;

public interface IUserBuilder {
    User build();

    UserBuilder setName(String name);

    UserBuilder setSurname(String surname);

    UserBuilder setId(int id);
}