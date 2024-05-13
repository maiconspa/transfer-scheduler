package br.com.TransferScheduler.service;

import br.com.TransferScheduler.dto.TransferDTO;
import br.com.TransferScheduler.model.Transfer;
import br.com.TransferScheduler.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public TransferDTO scheduleTransfer(TransferDTO transferDTO) {
        Double fee = calculateTransferFee(transferDTO);

        Transfer transfer = new Transfer();
        transfer.setSourceAccount(transferDTO.getSourceAccount());
        transfer.setDestinationAccount(transferDTO.getDestinationAccount());
        transfer.setAmount(transferDTO.getAmount());
        transfer.setTransferDate(transferDTO.getTransferDate());
        transfer.setSchedulingDate(transferDTO.getSchedullingDate());
        transfer.setFee(fee);

        transfer = transferRepository.save(transfer);

        return convertToTransferDTO(transfer);
    }

    public List<TransferDTO> getTransferHistory() {
        List<Transfer> transfers = transferRepository.findAll();

        List<TransferDTO> transferDTOs = new ArrayList<>();
        for (Transfer transfer : transfers) {
            transferDTOs.add(convertToTransferDTO(transfer));
        }

        return transferDTOs;
    }


    private Double calculateTransferFee(TransferDTO transferDTO) {

        long days = ChronoUnit.DAYS.between(transferDTO.getSchedullingDate(), transferDTO.getTransferDate());
        System.out.println("DAYS: " + days);


        if (days == 0 ) {
            return ((transferDTO.getAmount().doubleValue() * 2.5) / 100) + 3;
        } if (days > 0 && days <= 10) {
            return new Double(12);
        } if (days > 10 && days <= 20) {
            return ((transferDTO.getAmount().doubleValue() * 8.2) / 100);
        } if (days > 20 && days <= 30) {
            return ((transferDTO.getAmount().doubleValue() * 6.9) / 100);
        } if (days > 30 && days <= 40) {
            return ((transferDTO.getAmount().doubleValue() * 4.7) / 100);
        } if (days > 40 && days <= 50) {
            return ((transferDTO.getAmount().doubleValue() * 1.7) / 100);
        } else {
            throw new IllegalArgumentException("Não foi possível realizar a transferencia: prazo inválido");
        }
    }

    private TransferDTO convertToTransferDTO(Transfer transfer) {
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setSourceAccount(transfer.getSourceAccount());
        transferDTO.setDestinationAccount(transfer.getDestinationAccount());
        transferDTO.setAmount(transfer.getAmount());
        transferDTO.setTransferDate(transfer.getTransferDate());

        return transferDTO;
    }

    public List<TransferDTO> getByAccount(String accountNumber) {
        List<Transfer> transferList = transferRepository.findBySourceAccount(accountNumber);
        List<TransferDTO> transferDTOList = new ArrayList<>();
        transferList.forEach(transferObj -> transferDTOList.add(transferObj.toDTO()));

        return transferDTOList;
    }
}
