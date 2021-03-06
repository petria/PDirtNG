package com.freakz.pdirtng.engine;

import com.freakz.pdirtng.engine.handlers.EngineBaseHandler;

import java.lang.reflect.Method;

/**
 * Date: 4.8.2011
 * Time: 16:04
 */
public class DynamicHandlerClass {

  public String matcher;
  public Method method;
  public EngineBaseHandler ownerClass;

  public DynamicHandlerClass(String matcher, Method method, EngineBaseHandler ownerClass) {
    this.matcher = matcher;
    this.method = method;
    this.ownerClass = ownerClass;
  }

  public String getMatcher() {
    return matcher;
  }

  public Method getMethod() {
    return method;
  }

  public EngineBaseHandler getOwnerClass() {
    return ownerClass;
  }
}
