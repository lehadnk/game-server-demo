package gooddeeds.demoserver.models;

public class User {
    private final long id;
    private final String username;

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return this.id;
    }

    public String getUsername()
    {
        return this.username;
    }
}
