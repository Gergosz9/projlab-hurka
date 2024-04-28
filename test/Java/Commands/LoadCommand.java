class LoadCommand implements Command {
    private Labirinth labirinth;

    public LoadCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {
        
    }
} //betölti a labirintust (jsonb?l ?)