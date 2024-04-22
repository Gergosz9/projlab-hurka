package Java.Items.Triggers;

import javax.swing.plaf.SliderUI;

import Java.Characters.Character;
import Java.Items.*;

public class WinTrigger extends Trigger {
    public WinTrigger(Character character) {
        super(character);
    }

    public void handle(SlideRule s) {
        s.trigger(this);
    }
}
