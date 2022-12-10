package items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeTop {
    private final List<List<Integer>> treeTopRows;
    private final int height;
    private final int width;

    public TreeTop(List<List<Integer>> treeTopRows) {
        this.treeTopRows = treeTopRows;

        height = treeTopRows.size();
        width = treeTopRows.get(0).size();
    }

    public Integer findLargestScenicScore() {
        int maxScenicScore = 0;

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                maxScenicScore = Math.max(findScenicScore(x, y), maxScenicScore);
            }
        }

        return maxScenicScore;
    }

    private int findScenicScore(int x, int y) {
        if (x == 0 || y == 0 || x == height - 1 || y == width - 1) {
            return 0;
        }

        int targetTreeSize = getTreeSize(x, y);

        List<Integer> treesUp = getAllInDirection(x, y, -1, 0);
        List<Integer> treesRight = getAllInDirection(x, y, 1, 0);
        List<Integer> treesDown = getAllInDirection(x, y, 0, 1);
        List<Integer> treesLeft = getAllInDirection(x, y, 0, -1);

        int scoreUp = findViewableTrees(targetTreeSize, treesUp).size();
        int scoreRight = findViewableTrees(targetTreeSize, treesRight).size();
        int scoreDown = findViewableTrees(targetTreeSize, treesDown).size();
        int scoreLeft = findViewableTrees(targetTreeSize, treesLeft).size();

        return scoreUp * scoreRight * scoreDown * scoreLeft;
    }

    private List<Integer> findViewableTrees(Integer currentSize, List<Integer> candidates) {
        List<Integer> viewable = new ArrayList<>();

        for (int i = 0; i < candidates.size(); i++) {
            int treeSize = candidates.get(i);

            viewable.add(treeSize);

            if (treeSize >= currentSize) {
                break;
            }
        }

        return viewable;
    }

    private List<Integer> getAllInDirection(int x, int y, int xIncrement, int yIncrement) {
        List<Integer> found = new ArrayList<>();

        int currentX = x + xIncrement;
        int currentY = y + yIncrement;
        while (isValidPosition(currentX, currentY)) {
            found.add(getTreeSize(currentX, currentY));

            currentX += xIncrement;
            currentY += yIncrement;
        }

        return found;
    }

    private boolean isValidPosition(int x, int y) {
        return !(x < 0 || y < 0 || x >= height || y >= width);
    }

    public Integer getVisibleTreeCount() {
        Set<TreeLocation> visibleLocations = new HashSet<>();

        // top to bottom
        for (int heightIndex = 0; heightIndex < height; heightIndex++) {
            int largestTree = -1;

            // left to right
            for (int widthIndex = 0; widthIndex < width; widthIndex++) {
                var treeHeight = treeTopRows.get(heightIndex).get(widthIndex);

                if (treeHeight > largestTree) {
                    largestTree = treeHeight;
                    visibleLocations.add(new TreeLocation(heightIndex, widthIndex));
                }
            }

            largestTree = -1;

            // right ot left
            for (int widthIndex = width - 1; widthIndex >= 0; widthIndex--) {
                var treeHeight = treeTopRows.get(heightIndex).get(widthIndex);

                if (treeHeight > largestTree) {
                    largestTree = treeHeight;
                    visibleLocations.add(new TreeLocation(heightIndex, widthIndex));
                }
            }
        }

        // left to right
        for (int widthIndex = 0; widthIndex < width; widthIndex++) {
            int largestTree = -1;

            // top to bottom
            for (int heightIndex = 0; heightIndex < height; heightIndex++) {
                var treeHeight = treeTopRows.get(heightIndex).get(widthIndex);

                if (treeHeight > largestTree) {
                    largestTree = treeHeight;
                    visibleLocations.add(new TreeLocation(heightIndex, widthIndex));
                }
            }

            largestTree = -1;

            // bottom to top
            for (int heightIndex = height - 1; heightIndex >= 0; heightIndex--) {
                var treeHeight = treeTopRows.get(heightIndex).get(widthIndex);

                if (treeHeight > largestTree) {
                    largestTree = treeHeight;
                    visibleLocations.add(new TreeLocation(heightIndex, widthIndex));
                }
            }
        }

        return visibleLocations.size();
    }

    private int getTreeSize(int x, int y) {
        return treeTopRows.get(x).get(y);
    }

    private record TreeLocation(int x, int y) {
    }
}
