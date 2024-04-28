package Java.Commands;
import Java.*;


public class LoadCommand implements Command {
    private Labirinth labirinth;

    public LoadCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {
        
    }
} //bet�lti a labirintust (jsonb?l ?)