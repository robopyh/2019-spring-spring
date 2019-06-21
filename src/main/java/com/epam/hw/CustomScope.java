package com.epam.hw;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class CustomScope implements Scope {

  private static final int USAGE_MIN = 1;
  private static final int USAGE_MAX = 3;
  private final Map<String, Pair<Integer, Object>> map = new HashMap<>();

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    if (map.containsKey(name)) {
      if (map.get(name).getLeft() < USAGE_MAX) {
        map.compute(name, (string, pair) -> Pair.of(pair.getLeft() + 1, pair.getRight()));
      } else {
        map.put(name, Pair.of(USAGE_MIN, objectFactory.getObject()));
      }
    } else {
      map.put(name, Pair.of(USAGE_MIN, objectFactory.getObject()));
    }

    return map.get(name).getRight();
  }

  @Override
  public Object remove(String name) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Object resolveContextualObject(String key) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getConversationId() {
    throw new UnsupportedOperationException();
  }
}
