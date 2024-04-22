package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

public class ActionTrigger extends Trigger {
    public ActionTrigger(Character character) {
        super(character);
    }

    public void handle(Transistor t) {
        t.trigger(this);
    }

    public void handle(Camembert c) {
        c.trigger(this);
    }

    public void handle(Rag r) {
        r.trigger(this);
    }

    public void handle(Beer b) {
        b.trigger(this);
    }

    public void handle(AirFreshener a) {
        a.trigger(this);
    }

}
