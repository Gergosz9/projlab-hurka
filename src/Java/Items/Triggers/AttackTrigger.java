package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

public class AttackTrigger extends Trigger {
    public AttackTrigger(Character character) {
        super(character);
    }

    public void handle(TVSZ t) {
        t.trigger(this);
    }
}
