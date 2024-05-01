package Java;

import Java.Commands.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestHandler {

    private Map<String, Command> commandMap;
    Labirinth labirinth;

    /**
     * Constructor of class TestHandler
     * 
     * @param labirinth it will contain the map of the game
     */
    public TestHandler(Labirinth labirinth) {
        this.labirinth = labirinth;
        commandMap = new HashMap<>();
        registerCommands();
    }

    /**
     * Function to register commands in hashmap
     *
     * it puts the used commands in a hashmap
     * the key is the name of the command,
     * the other is the Command objectum that belongs to it
     */
    private void registerCommands() {
        commandMap.put("move", new MoveCommand());
        commandMap.put("pickup", new PickUpCommand());
        commandMap.put("putdown", new PutDownCommand());
        commandMap.put("useitem", new UseItemCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("examinate", new ExamineCommand());
        // commandMap.put("wherecanmove", new WhereCanMoveCommand(labirinth));
        // commandMap.put("whereami", new WhereAmICommand(labirinth));
        // commandMap.put("itemsinroom", new ItemsInRoomCommand(labirinth));
        // commandMap.put("whatisinrooom", new WhatIsInRoomCommand(labirinth));
        // commandMap.put("itemsinhand", new ItemsInHandCommand(labirinth));
        // commandMap.put("help", new HelpCommand(labirinth));
        // commandMap.put("whoami", new WhoAmICommand(labirinth));
        // commandMap.put("listplayers", new ListPlayersCommand(labirinth));
        // commandMap.put("endmyturn", new EndMyTurnCommand(labirinth));
        /// commandMap.put("remainingsteps", new RemainingSteps(labirinth));
    }

    /**
     * Function execute commands
     *
     * It changes strings to commands
     * and to its arguments
     * and then executes them
     */
    public void executeCommand(String commandString) {
        String[] parts = commandString.split(" ");
        String commandName = parts[0];
        Command command = commandMap.get(commandName);
        // command = new C
        if (command != null) {
            command.execute(parts, labirinth);
        } else {
            // Provide a more informative error message
            System.out.println("Command '" + parts[0] + "' not found or not supported.");
        }
    }

    /**
     * Function to read in commands
     */
    public void processCommandFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nKiadott parancsok\n");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                executeCommand(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}