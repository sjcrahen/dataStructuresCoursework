import java.util.Stack;

public class LeafPile {
  public static void main(String[] args) {
    Ground map[][] = new Ground[7][11];
    generateRandomGround(map);
    printMap(map);
    System.out.println(largestLeafPile(map));
  }

  /**********Student code here***************************/
  /*
   * CSC 385
   * Author: Shawn Crahen (crah2)
   * 2/23/2020
   */
  private static int largestLeafPile(Ground map[][]) {
    
    int largestPile = 0;
    Stack<Position> leafPileStack = new Stack<>();
    
    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < map[r].length; c++) {
        int thisPile = 0;
        if (map[r][c] == Ground.LEAF)
          leafPileStack.push(new Position(r, c));
        while (!leafPileStack.empty()) {
          Position testPosition = leafPileStack.peek();
          if (map[testPosition.row][testPosition.column] == Ground.LEAF) {
            //count leaf and mark position
            thisPile++;
            map[testPosition.row][testPosition.column] = Ground.GRASS;
            leafPileStack.pop();
            
            // push N, S, W, E positions to stack
            if (testPosition.row > 0 && testPosition.column < map[testPosition.row - 1].length)
              leafPileStack.push(new Position(testPosition.row - 1, testPosition.column)); // north
            if (testPosition.row < map.length - 1 && testPosition.column < map[testPosition.row + 1].length)
              leafPileStack.push(new Position(testPosition.row + 1, testPosition.column)); // south
            if (testPosition.column > 0)
              leafPileStack.push(new Position(testPosition.row, testPosition.column - 1)); // west
            if (testPosition.column < map[testPosition.row].length - 1)
              leafPileStack.push(new Position(testPosition.row, testPosition.column + 1)); // east
          }
          else {
            leafPileStack.pop();
          }
        }
        if (thisPile > largestPile)
          largestPile = thisPile;
      }
    }
    
    return largestPile;
  }

    
  /***************End Student Code************************/
  private static void printMap(Ground map[][]) {
    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < map[r].length; c++) {
        System.out.print(map[r][c]);
        if (c < map[r].length - 1) {
          System.out.print(' ');
        }
      }
      System.out.println();
    }
  }

  private static void generateRandomGround(Ground map[][]) {
    double randGround;
    double randMax = 100;
    double percentGrass = .70;
    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < map[r].length; c++) {
        randGround = (Math.random() * randMax) + 1;
        map[r][c] = randGround <= randMax * percentGrass ? Ground.GRASS : Ground.LEAF;
      }
    }
  }
}