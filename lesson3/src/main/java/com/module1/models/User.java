package com.module1.models;

public class User {

  private String name;
  private City city;


  public User(String name, City city) {
    this.name = name;
    this.city = city;
  }

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", city=" + city +
        '}';
  }
}
