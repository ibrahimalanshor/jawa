class InvalidMenuNumberException extends IllegalArgumentException {
    private static final String message = "Invalid Menu Number";

    public InvalidMenuNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMenuNumberException(String message) {
        super(message);
    }

    public InvalidMenuNumberException(Throwable cause) {
        super(InvalidMenuNumberException.message, cause);
    }

    public InvalidMenuNumberException() {
        super(InvalidMenuNumberException.message);
    }
}