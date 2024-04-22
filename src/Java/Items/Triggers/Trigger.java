package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

public abstract class Trigger {
    Character character;

    public Trigger(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void handle(Item i) {
    }

    public void handle(Transistor t) {
    }

    public void handle(Camembert c) {
    }

    public void handle(Rag r) {
    }

    public void handle(TVSZ t) {
    }

    public void handle(Beer b) {
    }

    public void handle(Mask m) {
    }

    public void handle(SlideRule s) {
    }

    public void handle(AirFreshener a) {
    }
}
