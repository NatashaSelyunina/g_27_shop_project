package de.aittr.g_27_shop_project.domain.interfaces;

public interface Product {

    int getId();
    boolean isActive();
    void setActive(boolean isActive);
    String getName();
    void setName(String name);
    double getPrice();
    void setPrice(double price);
    void setId(int id);
}