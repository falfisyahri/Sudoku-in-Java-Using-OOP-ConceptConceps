package ProjectUAS;

class PapanPermainan extends PapanSudoku {
    @Override
    public boolean langkahValid(int baris, int kolom, int nilai) {
        if (baris < 0 || baris >= UKURAN || kolom < 0 || kolom >= UKURAN || nilai < 1 || nilai > 9 || selTetap[baris][kolom]) {
            return false;
        }

        for (int i = 0; i < UKURAN; i++) {
            if (papan[baris][i] == nilai || papan[i][kolom] == nilai) {
                return false;
            }
        }

        int awalBaris = (baris / 3) * 3;
        int awalKolom = (kolom / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (papan[awalBaris + i][awalKolom + j] == nilai) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean apakahSelesai() {
        for (int i = 0; i < UKURAN; i++) {
            for (int j = 0; j < UKURAN; j++) {
                if (papan[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void buatPapan(Randomizer randomizer) {
        randomizer.isiPapanAwal(this);
        System.out.println("Papan permainan telah dibuat.");
    }
}
