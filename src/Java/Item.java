package Java;

public abstract class Item {
    protected int durability;
    public Item(int durability){
        this.durability = durability;
    }
    public abstract void use(ItemTrigger trigger, Character source); 
}
