package com.merryapps.rxarch.model.repositories;

/**
 * A Github repository
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class Repository {

  private ItemRaw itemRaw;

  Repository(ItemRaw itemRaw) {
    this.itemRaw = itemRaw;
  }

  ItemRaw getItemRaw() {
    return itemRaw;
  }

  public String getName() {
    return itemRaw.getFullName();
  }
}
