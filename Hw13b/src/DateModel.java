package hw13b.src;
import java.time.LocalDate; // [cite: 139]
import java.time.format.DateTimeFormatter;

public class DateModel {
    private LocalDate currentDate;

    public DateModel() {
        this.currentDate = LocalDate.now();
    }

    public void addDays(int days) { currentDate = currentDate.plusDays(days); } // [cite: 124]
    public void minusDays(int days) { currentDate = currentDate.minusDays(days); } // [cite: 123]
    public void addMonths(int months) { currentDate = currentDate.plusMonths(months); } // [cite: 126]
    public void minusMonths(int months) { currentDate = currentDate.minusMonths(months); } // [cite: 125]

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // [cite: 113]
        return currentDate.format(formatter);
    }
}