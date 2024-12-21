package ProjectUAS;

abstract class PapanSudoku {
    protected final int[][] papan;
    protected final boolean[][] selTetap;
    protected static final int UKURAN = 9;

    public PapanSudoku() {
        papan = new int[UKURAN][UKURAN];
        selTetap = new boolean[UKURAN][UKURAN];
    }

    public abstract boolean langkahValid(int baris, int kolom, int nilai);

    public abstract boolean apakahSelesai();

    public void aturSel(int baris, int kolom, int nilai) {
        papan[baris][kolom] = nilai;
    }

    public void tampilkanPapan() {
        System.out.println("  1 2 3   4 5 6   7 8 9");
        for (int i = 0; i < UKURAN; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("  ------+-------+------");
            }
            System.out.print((i + 1) + " ");
            for (int j = 0; j < UKURAN; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(papan[i][j] == 0 ? ". " : papan[i][j] + " ");
            }
            System.out.println();
        }
    }
}
