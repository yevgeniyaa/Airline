package entity;

public abstract class Plane {

    protected String name;
    protected int range;
    protected float payLoad;
    protected float holdingCapacity;

    protected Plane(String name, int range, float holdingCapacity) {
        this.name = name;
        this.range = range;
        this.holdingCapacity = holdingCapacity;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    public float getHoldingCapacity() {
        return holdingCapacity;
    }

    protected void setHoldingCapacity(float holdingCapacity) {
        this.holdingCapacity = holdingCapacity;
    }

    public int getRange() {
        return range;
    }

    protected void setRange(int range) {
        this.range = range;
    }

    public abstract float getPayLoad();
}