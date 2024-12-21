package ProjectUAS;

import java.util.Random;

class Randomizer {
    private final Random random = new Random();

    public void isiPapanAwal(PapanSudoku papan) {
        for (int i = 0; i < PapanSudoku.UKURAN; i++) {
            for (int j = 0; j < PapanSudoku.UKURAN; j++) {
                if (random.nextInt(100) < 25) {
                    int nilai;
                    do {
                        nilai = random.nextInt(9) + 1;
                    } while (!papan.langkahValid(i, j, nilai));
                    papan.aturSel(i, j, nilai);
                    papan.selTetap[i][j] = true;
                }
            }
        }
    }
}
