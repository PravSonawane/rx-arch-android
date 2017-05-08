package com.merryapps.rxarch.model.cache;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public class CacheManager<T> {

  private Cache<T> cache;

  public CacheManager() {
  }

  public void create(T data) {
    this.cache = new SingleObjectCache<>(data);
  }

  public void update(T data) {
    this.cache = new SingleObjectCache<>(data);
  }

  public T data() {
    return cache.data();
  }
}
