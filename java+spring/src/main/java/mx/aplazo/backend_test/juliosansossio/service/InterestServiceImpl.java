package mx.aplazo.backend_test.juliosansossio.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterestResponse;
import mx.aplazo.backend_test.juliosansossio.domain.Interest;
import mx.aplazo.backend_test.juliosansossio.repository.InterestRepository;

@Service
@Validated
public class InterestServiceImpl implements InterestService {
    @Autowired
    private InterestRepository interestRepository;

    public List<Interest> list() {
        return interestRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public Interest save(@NotNull @Valid Interest interest) {
        return interestRepository.save(interest);
    }

    public List<CalculateInterestResponse> calculate(@Valid CalculateInterest body) {
        List<CalculateInterestResponse> response = new ArrayList<>();

        Double amount = body.getAmount();
        Integer terms = body.getTerms();
        Double rate = body.getRate();

        Double totalToPay = amount + (rate / 100) * amount;
        Double totalPerPayment = totalToPay / terms;

        for (int i = 1; i <= terms; i++) {
            CalculateInterestResponse calculateInterestResponse = new CalculateInterestResponse();
            calculateInterestResponse.setPayment_number(i);
            calculateInterestResponse.setAmount(totalPerPayment);
            calculateInterestResponse.setPayment_date(new Date());
            response.add(calculateInterestResponse);
        }

        return response;
    }
}
