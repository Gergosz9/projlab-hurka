package Java;

import Java.Commands.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestHandler {

    private Map<String, Command> commandMap;
    Labirinth labirinth;

    public TestHandler(Labirinth Labirinth) {
        this.labirinth = labirinth;
        commandMap = new HashMap<>();
        registerCommands();
    }

    private void registerCommands() {
        // Parancsok regisztr�l�sa a megfelel? Command implement�ci�kkal
        commandMap.put("move", new MoveCommand(labirinth));
        commandMap.put("pickup", new PickUpCommand(labirinth));
        commandMap.put("putdown", new PutDownCommand(labirinth));
        commandMap.put("useitem", new UseItemCommand(labirinth));
        commandMap.put("load", new LoadCommand(labirinth));
        commandMap.put("save", new SaveCommand(labirinth));
        commandMap.put("examinate", new ExaminateCommand(labirinth));
        //commandMap.put("wherecanmove", new WhereCanMoveCommand(labirinth));
        //commandMap.put("whereami", new WhereAmICommand(labirinth));
        //commandMap.put("itemsinroom", new ItemsInRoomCommand(labirinth));
        //commandMap.put("whatisinrooom", new WhatIsInRoomCommand(labirinth));
        //commandMap.put("itemsinhand", new ItemsInHandCommand(labirinth));
        //commandMap.put("help", new HelpCommand(labirinth));
        //commandMap.put("whoami", new WhoAmICommand(labirinth));
        //commandMap.put("listplayers", new ListPlayersCommand(labirinth));
        //commandMap.put("endmyturn", new EndMyTurnCommand(labirinth));
        ///commandMap.put("remainingsteps", new RemainingSteps(labirinth));
    }

    public void executeCommand(String commandString) {
        String[] parts = commandString.split(" ");
        String commandName = parts[0];
        Command command = commandMap.get(commandName);
        if (command != null) {
            command.execute(parts);
        } else {
            System.out.println("Invalid command!");
        }
    }

    public void processCommandFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                executeCommand(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}