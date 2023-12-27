import java.util.ArrayList;
import java.util.stream.Stream;

public class Table {
    private String[] headers;
    private ArrayList<String[]> rows = new ArrayList<>();
    private int[] headersWidth;
    private int maxWidth;

    public void setHeaders(String ...headers) {
        this.headers = headers;

        this.headersWidth = Stream.of(this.headers).mapToInt(header -> header.length()).toArray();
        this.maxWidth = Stream.of(this.headers).mapToInt(header -> header.length()).sum() + 6 + headers.length - 1;
    }

    public void addRow(String ...cells) {
        this.rows.add(cells);
    }

    public void printLine() {
        System.out.print("+");

        for (int i = 0; i < this.headersWidth.length; i++) {
            int width = this.headersWidth[i];

            for (int j = 0; j < width + 2; j++) {
                System.out.print("-");
            }

            if (i < this.headersWidth.length - 1) {
                System.out.print("+");
            }
        }

        System.out.print("+");

        System.out.println();
    }

    public void printHeader() {
        System.out.print("|");

        for (int i = 0; i < this.headers.length; i++) {
            String header = headers[i];

            System.out.print(" " + header + " ");

            if (i < headers.length - 1) {
                System.out.print("|");
            }
        }
        
        System.out.print("|");

        System.out.println();
    }

    public void printRows() {
        if (this.rows.size() < 1) {
            System.out.print("|");

            System.out.print(" Empty ");

            for (int i = 0; i < this.maxWidth - 9; i ++) {
                System.out.print(" ");
            }

            System.out.print("|");
            System.out.println();
        } else {
            this.rows.forEach(row -> {
                System.out.print("|");
            
                for (int i = 0; i < this.headers.length; i++) {
                    StringBuilder content = new StringBuilder(row[i]);
                    int cellWidth = this.headersWidth[i];
                    
                    if (content.length() < cellWidth) {
                        content.append(" ".repeat(cellWidth - content.length()));
                    }

                    content.insert(0, " ");
                    content.append(" ");

                    System.out.print(content);

                    if (i < headers.length - 1) {
                        System.out.print("|");
                    }
                }
                
                System.out.print("|");

                System.out.println();
            });
        }
    }

    public void print() {
        this.printLine();
        this.printHeader();
        this.printLine();
        this.printRows();
        this.printLine();
    }
}