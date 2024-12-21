package ProjectUAS;

import java.util.Scanner;

class GameController {
    private final Scanner input = new Scanner(System.in);
    private final PapanSudoku papan;

    public GameController(PapanSudoku papan) {
        this.papan = papan;
    }

    public void mulaiPermainan() {
        System.out.println("Selamat datang di Sudoku!");
        Randomizer randomizer = new Randomizer();
        if (papan instanceof PapanPermainan) {
            ((PapanPermainan) papan).buatPapan(randomizer);
        }

        while (!papan.apakahSelesai()) {
            papan.tampilkanPapan();
            System.out.print("Masukkan langkah Anda (baris kolom nilai, atau -1 untuk keluar): ");
            int baris = input.nextInt();

            if (baris == -1) {
                System.out.println("Keluar dari permainan. Sampai jumpa!");
                break;
            }

            int kolom = input.nextInt() - 1;
            int nilai = input.nextInt();

            if (papan.langkahValid(baris - 1, kolom, nilai)) {
                papan.aturSel(baris - 1, kolom, nilai);
            } else {
                System.out.println("Langkah tidak valid! Coba lagi.");
            }
        }

        if (papan.apakahSelesai()) {
            System.out.println("Selamat! Anda telah menyelesaikan papan Sudoku!");
            papan.tampilkanPapan();
        }
    }
}