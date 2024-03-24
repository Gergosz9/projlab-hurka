package Java;

public class Camembert extends Item{
    public Camembert() {
    	super(1);
    }
    
    public void use(ItemTrigger trigger, Character source){
        if(trigger == ItemTrigger.UseActiveItem){
            durability--;
            source.getMyLocation().setGassed(true);
            if(durability == 0){
                source.drop(this, null); //pontosítani kell
            }
        }
    }
    
}
