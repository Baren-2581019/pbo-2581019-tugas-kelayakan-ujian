import java.util.Scanner;

public class KelayakanUjian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kehadiran (%)   : ");
        double kehadiran = scanner.nextDouble();

        System.out.print("Nilai tugas     : ");
        double nilaiTugas = scanner.nextDouble();

        System.out.print("Dispensasi      : ");
        boolean dispensasi = scanner.nextBoolean();

        // Tiga versi penulisan ekspresi kelayakan
        boolean a = kehadiran >= 75 && nilaiTugas >= 60 || dispensasi;
        boolean b = (kehadiran >= 75 && nilaiTugas >= 60) || dispensasi;
        boolean c = kehadiran >= 75 && (nilaiTugas >= 60 || dispensasi);

        boolean notDispensasi = !dispensasi;

        /*
         * Kesimpulan:
         * Hasil dari variabel 'a' selalu SAMA dengan 'b'.
         * && mengikat lebih kuat daripada ||, jadi Java membaca a persis seperti b.
         */

        // Pembuktian short-circuit
        int cek = 0;
        boolean x = (kehadiran >= 75) && (cek++ >= 0);
        boolean y = (nilaiTugas >= 60) || (cek++ >= 0);

        /*
         * Penjelasan kenapa 'cek' berakhir di 0 (dengan input contoh: 60, 80, true):
         * 1. Pada variabel x: Evaluasi (kehadiran >= 75) menghasilkan FALSE. Karena operator && (AND) mensyaratkan kedua sisi TRUE, Java menghentikan evaluasi (short-circuit) dan tidak menjalankan (cek++ >= 0).
         * 2. Pada variabel y: Evaluasi (nilaiTugas >= 60) menghasilkan TRUE. Karena operator || (OR) hanya butuh satu TRUE agar keseluruhan bernilai TRUE, Java menghentikan evaluasi (short-circuit) dan tidak menjalankan (cek++ >= 0).
         * Akibatnya, variabel 'cek' tidak pernah mengalami increment dan tetap 0.
         */

        System.out.println("\na (tanpa kurung)       : " + a);
        System.out.println("b (kurung precedence)  : " + b);
        System.out.println("c (kurung digeser)     : " + c);
        System.out.println("!dispensasi            : " + notDispensasi);
        System.out.println("cek dipanggil          : " + cek);

        scanner.close();
    }
}


