package mypackage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionProcessing {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.parse("2023-11-01T12:00:00");
        LocalDateTime dateTime2 = LocalDateTime.parse("2023-11-01T13:00:00");
        LocalDateTime dateTime3 = LocalDateTime.parse("2023-11-01T14:00:00");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 200, dateTime1, "Completed"),
                new Transaction(2, 150, dateTime2, "Pending"),
                new Transaction(3, 300, dateTime3, "Completed")
        );

        // Filtering
        double threshold = 200;
        String desiredStatus = "Completed";
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(t -> t.getAmount() > threshold && t.getStatus().equals(desiredStatus))
                .collect(Collectors.toList());

        // Sorting
        List<Transaction> sortedTransactions = transactions.stream()
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());

        // Summarization
        double totalAmount = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        // Grouping
        Map<String, Double> statusTotalAmountMap = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getStatus,
                        Collectors.summingDouble(Transaction::getAmount)));

        // Displaying results
        System.out.println("Filtered Transactions:");
        filteredTransactions.forEach(t -> System.out.println(t.getId() + ": " + t.getAmount()));

        System.out.println("\nSorted Transactions:");
        sortedTransactions.forEach(t -> System.out.println(t.getId() + ": " + t.getAmount()));

        System.out.println("\nTotal Amount of all Transactions: " + totalAmount);

        System.out.println("\nGrouped Transactions by Status:");
        statusTotalAmountMap.forEach((status, total) ->
                System.out.println(status + ": " + total));
    }
}

