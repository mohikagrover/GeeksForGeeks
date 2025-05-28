class Solution {
    public boolean ValidCorner(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        Map<String, Boolean> seenPairs = new HashMap<>();

        for (int r1 = 0; r1 < rows - 1; r1++) {
            for (int r2 = r1 + 1; r2 < rows; r2++) {
                List<Integer> commonCols = new ArrayList<>();
                for (int c = 0; c < cols; c++) {
                    if (mat[r1][c] == 1 && mat[r2][c] == 1) {
                        commonCols.add(c);
                    }
                }

                if (commonCols.size() >= 2) {
                    return true;
                }
            }
        }

        return false;
    }
}