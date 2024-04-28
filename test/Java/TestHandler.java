


public class TestHandler {

    private Map<String, Command> commandMap;   
    Labirinth labirinth;

    public Test(Labirinth Labirinth) {
        this.labirinth = labirinth;
        commandMap = new HashMap<>();
        // Parancsok regisztrálása
        registerCommands();
    }

    private void registerCommands() {
        // Parancsok regisztrálása a megfelel? Command implementációkkal
        commandMap.put("move", new MoveCommand(labirinth));
        commandMap.put("wherecanmove", new WhereCanMoveCommand(labirinth));
        commandMap.put("whereami", new WhereAmICommand(labirinth));
        commandMap.put("itemsinroom", new ItemsInRoomCommand(labirinth));
        commandMap.put("whatisinrooom", new WhatIsInRoomCommand(labirinth));
        commandMap.put("pickup", new PickUpCommand(labirinth));
        commandMap.put("putdown", new PutDownCommand(labirinth));
        commandMap.put("itemsinhand", new ItemsInHandCommand(labirinth));
        commandMap.put("useitem", new UseItemCommand(labirinth));
        commandMap.put("help", new HelpCommand(labirinth));
        commandMap.put("load", new LoadCommand(labirinth));
        commandMap.put("save", new SaveCommand(labirinth));
        commandMap.put("whoami", new WhoAmICommand(labirinth));
        commandMap.put("listplayers", new ListPlayersCommand(labirinth));
        commandMap.put("endmyturn", new EndMyTurnCommand(labirinth));
        commandMap.put("remainingsteps", new RemainingSteps(labirinth));
        commandMap.put("examinate", new ExaminateCommand(labirinth));
        //commandMap.put("", new  );
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
                testEngine.executeCommand(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}