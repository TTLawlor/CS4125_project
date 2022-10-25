package ServicesManagement;

public interface CarriageType {
    enum WorkLevel {
        LOW,
        MODERATE,
        HIGH
    }

    // Should include work level: "Low, Moderate, High" and frequency: "Multiple times a day, Once a day, Every 3 days"
    String cleaningRoutine();

}
