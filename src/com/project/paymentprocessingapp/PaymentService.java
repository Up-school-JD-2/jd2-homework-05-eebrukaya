import exceptions.CustomException;

import java.util.Random;

public class PaymentService {

    public void makePayment(double amount, String cardNumber, String expirationDate, String securityCode) throws CustomException.InvalidAmountException,
            CustomException.InvalidSecurityCodeException,
            CustomException.InvalidCardNumberException,
            CustomException.InvalidExpirationDateException,
            CustomException.SystemNotWorkingException {
        boolean generateNumbers = true;

        if (amount <= 0 || amount % 1 != 0) {
            generateNumbers = false;
            throw new CustomException.InvalidAmountException("Geçersiz ödeme tutarı.");
        }

        if (!isValidCardNumber(cardNumber)) {
            generateNumbers = false;
            throw new CustomException.InvalidCardNumberException("Geçersiz kart numarası.");
        }

        if (!isValidExpirationDate(expirationDate)) {
            generateNumbers = false;
            throw new CustomException.InvalidExpirationDateException("Geçersiz son kullanma tarihi.");
        }

        if (!isValidSecurityCode(securityCode)) {
            generateNumbers = false;
            throw new CustomException.InvalidSecurityCodeException("Geçersiz güvenlik kodu.");
        }

        if (generateNumbers) {
            pay();
        }

    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }

    private boolean isValidExpirationDate(String expirationDate) {

        String[] parts = expirationDate.split("/");
        if (parts.length != 2) {
            return false;
        }
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        if (year < 2023 || month < 1 || month > 12) {
            return false;
        }

        return true;
    }

    private boolean isValidSecurityCode(String securityCode) {
        return securityCode.matches("\\d{3}");
    }

    private void pay() throws CustomException.SystemNotWorkingException {
        Random random = new Random();
        int randomNumber = random.nextInt(101);

        if (randomNumber > 75) {
            throw new CustomException.SystemNotWorkingException("Sistemde bir hata oluştu. Lütfen tekrar deneyin.");
        } else {
            System.out.println("Ödeme başarıyla gerçekleştirildi.");
        }
    }
}
