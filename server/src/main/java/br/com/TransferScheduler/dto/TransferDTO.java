package br.com.TransferScheduler.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransferDTO {
    private String sourceAccount;
    private String destinationAccount;
    private BigDecimal amount;
    private LocalDate transferDate;

    public LocalDate getSchedullingDate() {
        return LocalDate.now();
    }
}
