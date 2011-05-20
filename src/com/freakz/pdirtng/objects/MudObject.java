package com.freakz.pdirtng.objects;

/**
 * Date: 20.5.2011
 * Time: 13:07
 *
 * @author Petri Airio
 */
public class MudObject {

    private static long objectIdCounter = 0;

    private long objectId;

    public MudObject() {
        objectIdCounter++;
        this.objectId = objectIdCounter;
    }

    public long getObjectId() {
        return objectId;
    }


}
