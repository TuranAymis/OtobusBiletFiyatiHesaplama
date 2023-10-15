import java.util.Scanner;

public class Main {
    /*
    Proje Konusu;
    Java ile mesafeye ve durumlara göre otobüs bileti fiyatı hesaplayan programı yapın.
    Kullanıcıdan Mesafe (KM), yaş ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgileri ile mesafe başına ücret 0,10 TL / km olarak alın.
    İlk olarak yolculuğun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

    Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
    Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
    Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
    Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
    Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
    Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int distance;
        int age;
        int trip = 1;
        double ticketPrice;
        double ageDiscountPrice;
        double ageDiscountRate = 1;
        String error = "Hatalı giriş";

        System.out.print("Mesafeyi KM cinsinden giriniz: ");
        distance = scan.nextInt();
        System.out.print("Yaşınızı giriniz: ");
        age = scan.nextInt();
        System.out.println("Bilet tipinizi seçiniz:");
        System.out.print("Gidiş: 1, Gidiş-Geliş: 2 ");
        trip = scan.nextInt();

        if (distance > 0 && age  > 0 && (trip == 1 || trip == 2)){
            ticketPrice = distance *  0.10;
            if (age < 12){
                ageDiscountRate = 0.50;
            } else if (age >= 12 && age <=24) {
                ageDiscountRate = 0.10;
            } else if (age < 65) {
                ageDiscountRate = 0.30;
            }
            ageDiscountPrice = ticketPrice * ageDiscountRate;
            ticketPrice = ticketPrice - ageDiscountPrice;

            if (trip == 2){
                ticketPrice -= ticketPrice * 0.20;
                ticketPrice *= 2;
            }
            System.out.println("Toplam Tutar: " + ticketPrice);
        }else {
            System.out.println(error);
        }
    }
}
