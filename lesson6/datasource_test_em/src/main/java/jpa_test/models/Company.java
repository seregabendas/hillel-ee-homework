package jpa_test.models;

import jpa_test.DBColumn;
import jpa_test.DBTable;

@DBTable(name = "company")
public class Company {
    @DBColumn(name = "id")
    private Integer id;
    @DBColumn(name = "address")
    private String address;

    public Company() {
    }

    public Company(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
