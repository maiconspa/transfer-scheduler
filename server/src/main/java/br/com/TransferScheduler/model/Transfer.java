package br.com.TransferScheduler.model;

import br.com.TransferScheduler.dto.TransferDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String sourceAccount;
    @Column
    private String destinationAccount;
    @Column
    private BigDecimal amount;
    @Column
    private Double fee;
    @Column
    private LocalDate transferDate;
    @Column
    private LocalDate schedulingDate;

    public Transfer() {

    }

    public TransferDTO toDTO() {
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setSourceAccount(this.sourceAccount);
        transferDTO.setDestinationAccount(this.destinationAccount);
        transferDTO.setAmount(this.amount);
        transferDTO.setTransferDate(this.transferDate);

        return transferDTO;
    }
}
