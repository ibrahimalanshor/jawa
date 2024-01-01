import java.util.ArrayList;
import java.util.stream.Stream;

public class Table {
    private String[] columns;
    private int[] columnsWidths;

    public void setHeaders(String ...headers) {
        this.columns = headers;
        this.columnsWidths = Stream.of(headers).mapToInt(header -> header.length()).toArray();
    }

    public void addRow(String ...rows) {}

    public void printLine() {
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

    public void printHeader() {
        this.printLine();

        System.out.print('|');

        for (int i = 0; i < this.columns.length; i++) {
            String column = this.columns[i];

            System.out.print(' ' + column + ' ');
            
            if (i < this.columns.length - 1) {
                System.out.print('|');
            }
        }
        
        System.out.print('|');
        System.out.println();
        
        this.printLine();
    }

    public void print() {
        this.printHeader();
    }

}