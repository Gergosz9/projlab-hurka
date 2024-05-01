package Java.Commands;

import Java.*;
import Java.util.GameStorageUtil;

public class LoadCommand implements Command {
    private Labirinth labirinth;

    public LoadCommand(Labirinth l) {
        this.labirinth = l;
    }

    @Override
    public Labirinth execute(String[] args, Labirinth l) {
        labirinth = GameStorageUtil.load(args[1]);
        return labirinth;
    }
} // bet�lti a labirintust (jsonb?l ?)