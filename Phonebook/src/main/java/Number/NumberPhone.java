package Number;

import java.util.Objects;

public class NumberPhone {
    private String number;
    private NumberPhoneType type;

    public NumberPhone(String number, NumberPhoneType type) {
        this.number = number;
        this.type = type;
    }

    public final String getNumber() {
        return number;
    }

    public final NumberPhoneType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberPhone that = (NumberPhone) o;
        return Objects.equals(number, that.number) &&
                type == that.type;
    }

    @Override
    public String toString() {
        return number + ' ' + type.name();
    }
}
