package Java.Commands;
import Java.*;
import Java.util.GameStorageUtil;


public class LoadCommand implements Command {
    private Labirinth labirinth;

    public LoadCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {
        labirinth = GameStorageUtil.load(args[1]);
    }
} //bet�lti a labirintust (jsonb?l ?)