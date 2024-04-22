package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

public class RoundTrigger extends Trigger {
    public RoundTrigger(Character character) {
        super(character);
    }

    public void handle(Beer b) {
        b.trigger(this);
    }
}
