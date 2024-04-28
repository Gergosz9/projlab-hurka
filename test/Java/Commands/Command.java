interface Command {
    void execute(String[] args);

    public Room getRoomFromString(String s, List<Room> rooms){
    for (Roomr r : rooms) {
            if (r.getName().equals(s)) {
                return r;
            }
    }
}

    public Character getCharacterFromString(String s, List<Character> characters){
        for (Character c : characters) {
                if (c.getName().equals(args[1])) {
                    return c;
                }
        }
    }

    public Item getItemFromString(String s, List<Character> items){
        for (Item i : items) {
                if (i.getClass().getSimpleName().equals(args[1])) {
                    return i;
                }
        }  
    }
}