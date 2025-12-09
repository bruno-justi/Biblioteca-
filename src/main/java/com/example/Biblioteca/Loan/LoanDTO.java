package com.example.Biblioteca.Loan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

        private Long id;
        private LocalDateTime loanDate;
        private LocalDateTime returnDate;
        private String status;
        private Long userId;
        private Long bookId;

}
