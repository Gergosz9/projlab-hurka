package Java.Commands;

import Java.*;
import Java.util.GameStorageUtil;

public class LoadCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {
        l = GameStorageUtil.load(args[1]);
    }
} // betölti a labirintust (jsonból ?)