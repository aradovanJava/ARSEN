package hr.apisit.arsen.enumeration;

public enum StreetEnum {

  GLAVNA("Glavna"), ZAGREBACKA("Zagrebačka"),
  ZLEBEC("Žlebec"), SPORTSKA("Sportska"),
  SLAVONSKA("Slavonska"), PRIMORSKA("Primorska"),
  PRIGORSKA("Prigorska"), ZAGORSKA("Zagorska"),
  MEDJIMURSKA("Međimurska");

  private final String name;

  private StreetEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
