public class ExtraExample {
    public static void main(String[] args) {
        // Create a game character starting at position (0, 0)
        GameCharacter character = new GameCharacter(0, 0);

        // Display initial position
        character.displayPosition();

        // Move the character in different directions
        character.moveUp();
        character.moveRight();
        character.moveRight();
        character.moveDown();

        // Display final position
        character.displayPosition();
    }
}

// Class representing a game character
class GameCharacter {
    private int x; // X-coordinate of the character
    private int y; // Y-coordinate of the character

    // Constructor to initialize the character's position
    public GameCharacter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Move the character up
    public void moveUp() {
        y++;
        System.out.println("Moved up to (" + x + ", " + y + ")");
    }

    // Move the character down
    public void moveDown() {
        y--;
        System.out.println("Moved down to (" + x + ", " + y + ")");
    }

    // Move the character left
    public void moveLeft() {
        x--;
        System.out.println("Moved left to (" + x + ", " + y + ")");
    }

    // Move the character right
    public void moveRight() {
        x++;
        System.out.println("Moved right to (" + x + ", " + y + ")");
    }

    // Display the current position of the character
    public void displayPosition() {
        System.out.println("Current position: (" + x + ", " + y + ")");
    }
}
