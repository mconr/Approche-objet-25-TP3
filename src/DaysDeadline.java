import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysDeadline implements Deadline {

    private int days;              // Nombre de jours pour l'expiration
    private LocalDate startDate;   // Date de début pour le calcul de l'expiration

    // Constructeur pour initialiser le nombre de jours et la date de début
    public DaysDeadline(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Le nombre de jours doit être positif.");
        }
        this.days = days;
        this.startDate = LocalDate.now();  // On initialise à la date courante
    }

    // Méthode pour vérifier si le délai est expiré
    @Override
    public boolean expired() {
        // Calcule le nombre de jours écoulés depuis la date de départ
        long daysElapsed = ChronoUnit.DAYS.between(startDate, LocalDate.now());
        // Si les jours écoulés dépassent ou atteignent le délai, le délai est expiré
        return daysElapsed >= days;
    }

}
