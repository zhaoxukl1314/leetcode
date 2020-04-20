import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution36 {
    class Point {
        int row;
        int colume;
        char s;

        public Point(int row, int colume, char s) {
            this.row = row;
            this.colume = colume;
            this.s = s;
        }

        @Override
        public boolean equals(Object obj) {
            if (getClass() != obj.getClass()) {
                return false;
            }
            Point point = (Point) obj;
            return row == point.row || colume == point.colume || ((row / 3 == point.row / 3) && (colume / 3 == point.colume / 3));
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                Point point = new Point(i,j, board[i][j]);
                if (!set.contains(point)) {
                    set.add(point);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
