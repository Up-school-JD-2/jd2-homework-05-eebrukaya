import enums.PaymentMethod;
import exceptions.CustomException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        Scanner scanner = new Scanner(System.in);

        double amount = 0.0;
        String cardNumber = "";
        String expirationDate = "";
        String securityCode = "";

        System.out.println("\n");
        System.out.println("Misafir kullanıcı olarak ödeme için yönlendiriliyorsunuz.. \n ");

        System.out.println("Ödeme Yöntemi Seçin:");

        for (PaymentMethod method : PaymentMethod.values()) {
            System.out.println((method.ordinal() + 1) + ". " + method.getDisplayName());
        }

        System.out.print("Seçiminizi yapın (1-" + PaymentMethod.values().length + "): ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > PaymentMethod.values().length) {
            System.out.println("Geçersiz seçim.");
            return;
        }
        PaymentMethod selectedMethod = PaymentMethod.values()[choice - 1];

        if (selectedMethod.getDisplayName().equalsIgnoreCase(PaymentMethod.CREDIT_CARD.getDisplayName())) {
            System.out.print("Ödeme tutarını girin: ");
            amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Kart numarasını girin: ");
            cardNumber = scanner.nextLine();

            System.out.print("Son kullanma tarihini girin (MM/YYYY): ");
            expirationDate = scanner.nextLine();

            System.out.print("Güvenlik kodunu girin: ");
            securityCode = scanner.nextLine();
            try {
                paymentService.makePayment(amount, cardNumber, expirationDate, securityCode);

            } catch (CustomException.InvalidAmountException | CustomException.InvalidCardNumberException |
                     CustomException.InvalidExpirationDateException | CustomException.InvalidSecurityCodeException e) {
                System.out.println("Hata: " + e.getMessage());
            } catch (CustomException.SystemNotWorkingException e) {
                System.out.println("Hata: " + e.getMessage());
                try {
                    paymentService.makePayment(amount, cardNumber, expirationDate, securityCode);
                } catch (Exception ex) {
                    System.out.println("Hata: " + ex.getMessage());
                }
            }
        }
    }
}

