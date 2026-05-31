package hust.soict.dsai.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DateModel {

    private final ObjectProperty<LocalDate> selectedDate =
            new SimpleObjectProperty<>(LocalDate.now());

    private final ObjectProperty<LocalDate> resultDate =
            new SimpleObjectProperty<>(LocalDate.now());

    private final StringProperty dateFormat =
            new SimpleStringProperty("dd/MM/yyyy");

    public ObjectProperty<LocalDate> selectedDateProperty() {
        return selectedDate;
    }

    public ObjectProperty<LocalDate> resultDateProperty() {
        return resultDate;
    }

    public StringProperty dateFormatProperty() {
        return dateFormat;
    }

    public String getFormattedSelectedDate() {
        return selectedDate.get()
                .format(DateTimeFormatter.ofPattern(dateFormat.get()));
    }

    public String getFormattedResultDate() {
        return resultDate.get()
                .format(DateTimeFormatter.ofPattern(dateFormat.get()));
    }

    public void calculate(
            int amount,
            Direction direction,
            TimeUnit unit) {

        LocalDate baseDate = selectedDate.get();

        if(direction == Direction.BEFORE) {
            amount = -amount;
        }

        switch(unit) {

            case DAYS:
                resultDate.set(baseDate.plusDays(amount));
                break;

            case MONTHS:
                resultDate.set(baseDate.plusMonths(amount));
                break;

            case YEARS:
                resultDate.set(baseDate.plusYears(amount));
                break;
        }
    }
}
