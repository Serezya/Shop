package org.example;

public class UserBuilder implements IUserBuilder {
    protected String name;
    protected String surname;
    protected int id;

    @Override
    public User build() {
        User user;
        if (surname == null || name == null)
            throw new IllegalStateException("Ошибка в имени или фамилии человека");
        if (id > 0) {
            user = new User(name, surname, id);
        } else {
            user = new User(name, surname);
        }
        return user;
    }

    @Override
    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }
}
