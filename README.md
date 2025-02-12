# Maze Solver

Maze Solver is a project designed to find a path through a maze from a given start position to an exit. The system reads a maze from a file, performs the maze-solving algorithm, and outputs the results.

## Project Overview

Maze Solver is developed using Java and provides functionalities for reading a maze, displaying it with indices, and solving it using a right-hand rule algorithm.

### Features

The project includes:
1. **Maze Reading**: Reads a maze from a text file.
2. **Maze Display**: Prints the maze with row and column indices for better visualization.
3. **Path Checking**: Checks if a path is clear for movement within the maze.
4. **Maze Solving**: Solves the maze using a right-hand rule algorithm starting from a specified position.
5. **Command Line Interface**: Reads input data from files and displays results on the console.

## Technologies Used

- **Java**: The primary programming language used for developing the maze solver system.

## Project Structure

The project structure includes several files organized as follows:

- **`src/MazeSolver.java`**: The main file that implements the maze-solving logic.
- **`src/maze.txt`**: The input file containing the maze structure.

## Usage

### Prerequisites

To run the project, you need to have the following installed:
- **Java Development Kit (JDK)**: Ensure you have JDK installed on your system.

### Running the Project

1. Clone the repository:

    ```bash
    git clone https://github.com/barissolcay/maze-solver.git
    cd maze-solver
    ```

2. Compile the Java file:

    ```bash
    javac src/MazeSolver.java
    ```

3. Run the Maze Solver with the start position and maze file:

    ```bash
    java -cp src MazeSolver <startX> <startY> <mazeFile>
    ```

    Replace `<startX>`, `<startY>`, and `<mazeFile>` with actual values. For example:

    ```bash
    java -cp src MazeSolver 0 0 src/maze.txt
    ```

## Contributing

We welcome contributions to improve the Maze Solver project. Feel free to open issues or submit pull requests if you have suggestions for improvements or find any bugs.

## License

MIT License

```markdown
MIT License

Copyright (c) 2025 Baris Solcay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
