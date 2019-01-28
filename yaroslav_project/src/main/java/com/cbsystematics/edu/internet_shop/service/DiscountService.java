package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entity.Discount;
import com.cbsystematics.edu.internet_shop.repository.IDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    private final IDiscountRepository discountRepository;

    @Autowired
    public DiscountService(IDiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Discount get(Integer id) {
        return discountRepository.get(id);
    }

    public Discount create(Discount discount) {
        return discountRepository.create(discount);
    }

    public Discount update(Discount discount) {
        return discountRepository.update(discount);
    }

    public void delete(Integer id) {
        discountRepository.delete(id);
    }

    public List<Discount> getAll() {
        return discountRepository.getAll();
    }
}
