import java.util.ArrayList;
import java.util.Arrays;

public class Table {
    private String[] columns;
    private int[] columnsWidths;
    private ArrayList<String[]> rows = new ArrayList<>();

    public void setHeaders(String ...headers) {
        this.columns = headers;
        this.columnsWidths = Arrays.stream(headers).mapToInt(header -> header.length()).toArray();
    }

    public void addRow(String ...rows) {
        this.rows.add(rows);

        for (int i = 0; i < rows.length; i++) {
            this.columnsWidths[i] = Math.max(this.columnsWidths[i], rows[i].length());
        }
    }

    private void printLine() {
        System.out.print('+');

        for (int i = 0; i < this.columnsWidths.length; i++) {
            int columnWidth = this.columnsWidths[i];

            System.out.print('-');

            for (int j = 0; j < columnWidth; j++) {
                System.out.print('-');
            }

            System.out.print('-');

            if (i < this.columnsWidths.length - 1) {
                System.out.print('+');
            }
        }

        System.out.print('+');
        System.out.println();
    }

    private void printCell(String content, int columnWidth) {
        StringBuilder whiteSpace = new StringBuilder();
        int remainingColumnWidth = columnWidth - content.length();
        
        if (remainingColumnWidth > 0) {
            whiteSpace.append(" ".repeat(remainingColumnWidth));
        }

        System.out.print(' ' + content + whiteSpace + ' ');
    }

    private void printHeader() {
        this.printLine();

        System.out.print('|');

        for (int i = 0; i < this.columns.length; i++) {
            String content = this.columns[i];
            int columnWidth = this.columnsWidths[i];

            this.printCell(content, columnWidth);

            if (i < this.columns.length - 1) {
                System.out.print('|');
            }
        }
        
        System.out.print('|');
        System.out.println();
        
        this.printLine();
    }

    private void printEmptyCell() {
        System.out.print('|');
            
        int totalColumnWidth = Arrays.stream(this.columnsWidths).sum();
        int totalWhiteSpace = this.columns.length * 2 - 2;
        int totalSeparator = this.columns.length - 1;

        this.printCell("Empty", totalColumnWidth + totalWhiteSpace + totalSeparator);

        System.out.print('|');
        System.out.println();
    }

    private void printRows() {
        if (this.rows.size() < 1) {
            this.printEmptyCell();
        } else {
            for (String[] row : this.rows) {
                System.out.print('|');

                for (int i = 0; i < row.length; i++) {
                    String content = row[i];
                    int columnWidth = this.columnsWidths[i];

                    this.printCell(content, columnWidth);

                    if (i < row.length - 1) {
                        System.out.print('|');
                    }
                }

                System.out.print('|');
                System.out.println();
            }
        }

        this.printLine();
    }

    public void print() {
        this.printHeader();
        this.printRows();
    }

}