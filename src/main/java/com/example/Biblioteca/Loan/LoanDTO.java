package com.example.Biblioteca.Loan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

        private Long id;
        private String loanDate;
        private String returnDate;
        private String status;
        private Long userId;
        private Long bookId;
        private LoanModel loan;
}
