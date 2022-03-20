package modelo;

import java.util.Objects;

public class Member {

  private String nif;
  private String name;
  private String address;
  private String phoneNumber;
  private int age;
  private boolean sanctioned;


  public Member(String nif, String name, String address, String phoneNumber, int age) {
    this.nif = nif;
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.age = age;
    this.sanctioned = false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Member member = (Member) o;
    return age == member.age &&
            sanctioned == member.sanctioned &&
            Objects.equals(nif, member.nif) &&
            Objects.equals(name, member.name) &&
            Objects.equals(address, member.address) &&
            Objects.equals(phoneNumber, member.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nif, name, address, phoneNumber, age, sanctioned);
  }

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isSanctioned() {
    return sanctioned;
  }

  public void setSanctioned(boolean sanctioned) {
    this.sanctioned = sanctioned;
  }
}