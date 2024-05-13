package br.com.TransferScheduler.controller;

import br.com.TransferScheduler.dto.TransferDTO;
import br.com.TransferScheduler.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/schedule")
    public ResponseEntity<TransferDTO> scheduleTransfer(@RequestBody TransferDTO transferDTO) {
        try {
            TransferDTO scheduledTransfer = transferService.scheduleTransfer(transferDTO);
            return new ResponseEntity<>(scheduledTransfer, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/history/")
    public ResponseEntity<List<TransferDTO>> getTransferHistory() {
        List<TransferDTO> transferHistory = transferService.getTransferHistory();
        return new ResponseEntity<>(transferHistory, HttpStatus.OK);
    }

    @GetMapping("/history/getByAccount/{accountNumber}")
    public List<TransferDTO> getByAccount(@PathVariable String accountNumber) {
        return transferService.getByAccount(accountNumber);
    }
}
