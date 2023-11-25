package mypackage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    private int id;
    private double amount;
    private LocalDateTime timestamp;
    private String status;

    public Transaction(int id, double amount, LocalDateTime timestamp, String status) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }
}

