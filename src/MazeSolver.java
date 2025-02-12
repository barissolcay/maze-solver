import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeSolver {

    private static final int RIGHT = 0;
    private static final int DOWN  = 1;
    private static final int LEFT  = 2;
    private static final int UP    = 3;

    private static final int[] dx = {1, 0, -1, 0}; // Sağ, Aşağı, Sol, Yukarı
    private static final int[] dy = {0, 1, 0, -1};

    public static char[][] readMaze(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int rowCount = 0;

        // İlk geçiş: Satır sayısını belirle
        while ((line = reader.readLine()) != null) {
            rowCount++;
        }

        reader.close();
        reader = new BufferedReader(new FileReader(fileName));

        char[][] maze = new char[rowCount][];
        int row = 0;

        // İkinci geçiş: Labirenti oku
        while ((line = reader.readLine()) != null) {
            maze[row] = line.toCharArray();
            row++;
        }

        reader.close();
        return maze;
    }

    public static void printMazeWithIndices(char[][] maze) {
        // Sütun indekslerini yazdır
        System.out.print("   ");
        for (int x = 0; x < maze[0].length; x++) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Her satırı yazdır ve satır indeksini göster
        for (int y = 0; y < maze.length; y++) {
            System.out.print(y + "  ");
            for (int x = 0; x < maze[y].length; x++) {
                System.out.print(maze[y][x] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isPathClear(char[][] maze, int x, int y) {
        if (y >= 0 && y < maze.length && x >= 0 && x < maze[0].length) {
            char cell = maze[y][x];
            return cell == '.' || cell == 'X';
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Kullanım: java MazeSolver <startX> <startY> <mazeFile>");
            return;
        }

        int startX = Integer.parseInt(args[0]);
        int startY = Integer.parseInt(args[1]);
        String mazeFile = args[2];

        char[][] maze = readMaze(mazeFile);

        System.out.println("Labirent:");
        printMazeWithIndices(maze);

        if (!isPathClear(maze, startX, startY)) {
            System.out.println("Geçersiz başlangıç pozisyonu!");
            return;
        }

        int x = startX;
        int y = startY;
        int direction = RIGHT; // İlk yön sağ

        int maxSteps = maze.length * maze[0].length * 4;
        int steps = 0;

        while (steps < maxSteps) {
            steps++;

            // x ve y koordinatlarının sınırlar içinde olup olmadığını kontrol edin
            if (x < 0 || x >= maze[0].length || y < 0 || y >= maze.length) {
                System.out.println("Karakter labirentten çıktı, çözüm yok!");
                return;
            }

            // Çıkış bulundu
            if (maze[y][x] == 'X') {
                System.out.println("Çıkış bulundu: (" + x + ", " + y + ")");
                return;
            }

            // Sağdaki hücreyi kontrol et
            int rightDir = direction;
            int rightX = x + dx[rightDir];
            int rightY = y + dy[rightDir];

            if (isPathClear(maze, rightX, rightY)) {
                // Sağ boşsa, ilerle
                direction = rightDir;
                x = rightX;
                y = rightY;
                continue;
            }

            // Sağ doluysa sola dön ve boş bir yol bulana kadar sola dönerek kontrol et
            boolean moved = false;
            for (int i = 0; i < 3; i++) { // Maksimum 3 kez sola dön
                direction = (direction + 3) % 4; // Sola dön
                int newX = x + dx[direction];
                int newY = y + dy[direction];

                if (isPathClear(maze, newX, newY)) {
                    x = newX;
                    y = newY;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                System.out.println("There is no solution!");
                return;
            }
        }

        System.out.println("There is no solution!");
    }
}
