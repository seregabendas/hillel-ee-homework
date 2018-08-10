package jpa_test.models;

import jpa_test.DBColumn;
import jpa_test.DBFK;
import jpa_test.DBTable;

@DBTable(name = "users")
public class User {
    @DBColumn(name = "id")
    private Integer id;
    @DBColumn(name = "name")
    private String login;
    @DBFK
    @DBColumn(name = "company_id")
    private Company company;

    public User() {
    }

    public User(Integer id, String login, Company company) {
        this.id = id;
        this.login = login;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", company=" + company +
                '}';
    }
}
