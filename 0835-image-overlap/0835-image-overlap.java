class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int maxOverlap = 0;

        // Try every possible vertical shift
        for (int rowShift = -n + 1; rowShift < n; rowShift++) {

            // Try every possible horizontal shift
            for (int colShift = -n + 1; colShift < n; colShift++) {

                int overlap = 0;

                // Visit every row of img1
                for (int row = 0; row < n; row++) {

                    // Visit every column of img1
                    for (int col = 0; col < n; col++) {

                        // We only care about 1s in img1
                        if (img1[row][col] == 1) {

                            int newRow = row + rowShift;
                            int newCol = col + colShift;

                            // Check whether the moved position is inside img2
                            if (newRow >= 0 && newRow < n &&
                                newCol >= 0 && newCol < n) {

                                // Check if both images have 1
                                if (img2[newRow][newCol] == 1) {
                                    overlap++;
                                }
                            }
                        }
                    }
                }

                // Keep the largest overlap
                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}