package Java.Commands;

import Java.*;
import Java.util.JSONUtil;

public class SaveCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {
        String fileName = args[1] + "_output";

        try {
            JSONUtil.save(fileName, l);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
