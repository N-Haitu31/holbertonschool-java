public record Contact(String name, String email) {

    public Contact {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (email == null
                || email.indexOf('@') == -1
                || email.indexOf('@') != email.lastIndexOf('@')
                || email.indexOf('@') == 0
                || email.indexOf('@') == email.length() - 1) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
    }

    @Override
    public String toString() {
        return name + " <" + email + ">";
    }
}
