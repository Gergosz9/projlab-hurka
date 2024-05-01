package Java.Commands;

import Java.*;
import Java.util.JSONUtil;

import org.json.JSONObject;

public class ExamineCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {
        String fileName1 = "projlab-hurka/rsrc/saved-games/" + args[1] + ".json";
        String fileName2 = "projlab-hurka/rsrc/saved-games/" + args[1] + "_output.json";

        JSONObject ob1 = JSONUtil.load(fileName1);
        JSONObject ob2 = JSONUtil.load(fileName2);

        JSONUtil.compare(ob1, ob2);
    }
}
