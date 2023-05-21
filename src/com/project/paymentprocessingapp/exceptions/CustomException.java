package exceptions;

public class CustomException extends Exception {
    public static class InvalidAmountException extends Exception {
        public InvalidAmountException(String message) {
            super(message);
        }
    }

    public static class InvalidCardNumberException extends Exception {
        public InvalidCardNumberException(String message) {
            super(message);
        }
    }

    public static class SystemNotWorkingException extends Exception {
        public SystemNotWorkingException(String message) {
            super(message);
        }
    }

    public static class InvalidExpirationDateException extends Exception {
        public InvalidExpirationDateException(String message) {
            super(message);
        }
    }

    public static class InvalidSecurityCodeException extends Exception {
        public InvalidSecurityCodeException(String message) {
            super(message);
        }
    }
}
