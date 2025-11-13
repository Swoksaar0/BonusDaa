# MST Edge Removal and Replacement

## Description

This program demonstrates Minimum Spanning Tree (MST) construction using Kruskal's algorithm, edge removal, and efficient replacement edge finding to maintain the MST property.

## Features

- Build MST using Kruskal's algorithm with Union-Find
- Display MST edges before removal
- Remove an edge from the MST
- Find connected components after removal
- Efficiently find minimum-weight replacement edge
- Display new MST after reconnection

## Project Structure

```
mst-edge-removal/
├── Main.java
├── Graph.java
├── Edge.java
├── UnionFind.java
└── README.md
```

## Requirements

- Java Development Kit (JDK) 8 or higher
- Git (for cloning the repository)

## Installation and Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/mst-edge-removal.git
cd mst-edge-removal
```

### Step 2: Verify Java Installation

Check if Java is installed:

```bash
java -version
javac -version
```

If Java is not installed, download it from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/).

### Step 3: Compile the Program

Compile all Java files:

```bash
javac *.java
```

This will create `.class` files for each Java source file.

### Step 4: Run the Program

Execute the main class:

```bash
java Main
```

## Alternative Compilation (with bin directory)

If you prefer to separate source and compiled files:

### Create bin directory and compile:

```bash
mkdir -p bin
javac -d bin *.java
```

### Run from bin directory:

```bash
java -cp bin Main
```

## Expected Output

```
=== MST Edge Removal and Replacement ===

Original MST edges:
(1-2, w=1)
(0-2, w=2)
(3-4, w=2)
(4-5, w=3)
(0-1, w=4)
Total MST weight: 12

Removing edge: (3-4, w=2)

Components after removal:
Component 1: [0, 1, 2]
Component 2: [3, 5]
Component 3: [4]

Replacement edge found: (4-5, w=3)

New MST edges after replacement:
(1-2, w=1)
(0-2, w=2)
(4-5, w=3)
(0-1, w=4)
(3-5, w=6)
New MST total weight: 16
```

## How It Works

1. **Graph Construction**: Creates a weighted undirected graph with 6 vertices and 9 edges
2. **MST Building**: Uses Kruskal's algorithm with Union-Find to build the initial MST
3. **Edge Removal**: Removes one edge from the MST, creating disconnected components
4. **Component Detection**: Uses DFS to find all connected components after removal
5. **Replacement Finding**: Searches for the minimum-weight edge that reconnects the components
6. **MST Reconstruction**: Builds the new MST with the replacement edge

## Algorithm Complexity

- MST Construction: O(E log E)
- Component Finding: O(V + E)
- Replacement Edge: O(E)
- Overall: O(E log E)

## Customization

To test with a different graph, modify the `Main.java` file:

```java
Graph graph = new Graph(numberOfVertices);
graph.addEdge(vertex1, vertex2, weight);
```

## Troubleshooting

### "javac is not recognized"
- Java JDK is not installed or not in PATH
- Install JDK and add to system PATH

### "Error: Could not find or load main class Main"
- Make sure you're in the correct directory
- Ensure all `.java` files are compiled
- Check for compilation errors

### Compilation errors
- Ensure all 4 `.java` files are in the same directory
- Check Java version compatibility
