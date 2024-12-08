import java.util.*;

public class projek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Program Sorting ===");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Exit");
            System.out.print("Pilihan Anda (1/2/3): ");
            int metode = scanner.nextInt();
            scanner.nextLine();

            if (metode == 3) {
                System.out.println("Terima kasih telah menggunakan program ini!");
                exit = true;
                continue;
            }

            System.out.println("\nPilih urutan sorting:");
            System.out.println("1. Ascending");
            System.out.println("2. Descending");
            System.out.print("Pilihan Anda (1/2): ");
            int urutan = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\nMasukkan jumlah angka yang ingin diurutkan: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] angka = new int[n];

            System.out.println("Masukkan angka satu per satu:");
            for (int i = 0; i < n; i++) {
                System.out.print("Angka ke-" + (i + 1) + ": ");
                angka[i] = scanner.nextInt();
                scanner.nextLine();
            }

            boolean showProcess = askShowProcess(scanner);

            if (metode == 1) {
                selectionSort(angka, urutan == 1, showProcess);
            } else if (metode == 2) {
                insertionSort(angka, urutan == 1, showProcess);
            } else {
                System.out.println("Metode sorting tidak valid!");
                continue;
            }

            System.out.println("\nHasil setelah diurutkan:");
            System.out.println(Arrays.toString(angka));
        }
    }

    private static boolean askShowProcess(Scanner scanner) {
        System.out.print("\nApakah Anda ingin melihat proses sorting? (y/n): ");
        char pilihan = scanner.next().charAt(0);
        return pilihan == 'y' || pilihan == 'Y';
    }

    public static void selectionSort(int[] array, boolean ascending, boolean showProcess) {
        if (showProcess) {
            System.out.println("\nProses Selection Sort:");
            System.out.println("Array awal: " + Arrays.toString(array));
        }

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if ((ascending && array[j] < array[index]) || (!ascending && array[j] > array[index])) {
                    index = j;
                }
            }

            if (index != i) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;

                if (showProcess) {
                    System.out.println("Menukar " + array[index] + " dengan " + array[i] + ": " + Arrays.toString(array));
                }
            } else if (showProcess) {
                System.out.println("Tidak ada penukaran untuk iterasi ke-" + (i + 1));
            }
        }
    }

    public static void insertionSort(int[] array, boolean ascending, boolean showProcess) {
        if (showProcess) {
            System.out.println("\nProses Insertion Sort:");
            System.out.println("Array awal: " + Arrays.toString(array));
        }

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            if (showProcess) {
                System.out.println("\nKey yang dipilih: " + key);
            }

            while (j >= 0 && ((ascending && array[j] > key) || (!ascending && array[j] < key))) {
                array[j + 1] = array[j];
                j--;

                if (showProcess) {
                    System.out.println("Memindahkan " + array[j + 1] + " ke indeks " + (j + 2));
                    System.out.println("Array saat ini: " + Arrays.toString(array));
                }
            }

            array[j + 1] = key;

            if (showProcess) {
                System.out.println("Menyisipkan key " + key + " di indeks " + (j + 1));
                System.out.println("Array setelah penyisipan: " + Arrays.toString(array));
            }
        }
    }
}
