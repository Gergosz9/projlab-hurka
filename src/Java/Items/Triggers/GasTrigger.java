package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

public class GasTrigger extends Trigger {
    public GasTrigger(Character character) {
        super(character);
    }

    public void handle(Mask m) {
        m.trigger(this);
    }
}
