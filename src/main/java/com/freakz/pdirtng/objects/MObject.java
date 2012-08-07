package com.freakz.pdirtng.objects;

/**
 * Date: 20.5.2011
 * Time: 13:07
 *
 * @author Petri Airio
 */
public class MObject {

  private static long objectIdCounter = 0;

  private long objectId;

  public MObject() {
    objectIdCounter++;
    this.objectId = objectIdCounter;
  }

  public long getObjectId() {
    return objectId;
  }


}
