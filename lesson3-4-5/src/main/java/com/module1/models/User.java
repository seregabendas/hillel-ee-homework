package com.module1.models;

public class User {

  private int id;
  private String name;
  private City city;


  public User(int id, String name, City city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }

  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
            "id=" + id +
            ", name='" + name + '\'' +
            ", city=" + city +
            '}';
  }
}
