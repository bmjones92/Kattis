import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GlitchBot {

    private enum Command {
        Left,
        Right,
        Forward
    }

    private enum Direction {
        North(0, 1),
        East(1, 0),
        South(0, -1),
        West(-1, 0);

        private final int dx;

        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    /**
     * Checks if the given set of commands produces the correct result position.
     * @param commands The commands to run.
     * @param start The index of the first command to run.
     * @param posX The starting position's x coordinate.
     * @param posY The starting position's y coordinate.
     * @param dir The direction.
     * @param endX The ending position's x coordinate.
     * @param endY The ending position's y coordinate.
     * @return Whether the commands produce the desired result.
     */
    private static boolean isCorrectResult(List<Command> commands, int start, int posX, int posY, Direction dir, int endX, int endY) {
        for (var i = start; i < commands.size(); ++i) {
            switch (commands.get(i)) {
                case Left:
                    dir = Direction.values()[dir.ordinal() == 0 ? 3 : dir.ordinal() - 1];
                    break;
                case Right:
                    dir = Direction.values()[(dir.ordinal() + 1) % 4];
                    break;
                case Forward:
                    posX += dir.dx;
                    posY += dir.dy;
                    break;
            }
        }

        return (posX == endX && posY == endY);
    }


    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var destX = sc.nextInt();
            final var destY = sc.nextInt();

            final var commands = new ArrayList<Command>();

            final var numCommands = sc.nextInt();
            for (var i = 0; i < numCommands; ++i) {
                commands.add(Command.valueOf(sc.next()));
            }

            var posX = 0;
            var posY = 0;
            var dir = Direction.North;
            for (var i = 0; i < numCommands; ++i) {
                final var origCmd = commands.get(i);

                for (final var cmd : Command.values()) {
                    if (cmd == origCmd) {
                        continue;
                    }

                    commands.set(i, cmd);

                    if (isCorrectResult(commands, i, posX, posY, dir, destX, destY)) {
                        System.out.println((i + 1) + " " + cmd);
                        return;
                    }
                }

                commands.set(i, origCmd);

                // Not alternative branches work here, so use original branch for one step.
                switch (commands.get(i)) {
                    case Left:
                        dir = Direction.values()[dir.ordinal() == 0 ? 3 : dir.ordinal() - 1];
                        break;
                    case Right:
                        dir = Direction.values()[(dir.ordinal() + 1) % 4];
                        break;
                    case Forward:
                        posX += dir.dx;
                        posY += dir.dy;
                        break;
                }
            }
        }
    }

}

