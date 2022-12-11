package com.example.khusbu.Service;

import com.example.khusbu.Model.Deal;
import com.example.khusbu.Model.User;
import com.example.khusbu.Repository.DealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DealService {
    private final DealRepository dealRepository;

    public void addDeal(Deal deal){
        dealRepository.save(deal);
    }
    public List<Deal> getDeals(User user){
        return dealRepository.findByEmail(user.getEmail()).get();
    }
    public List<Deal> getAllDeals(){
        return dealRepository.findAll();
    }
    public Deal getDeal(long id){
        return dealRepository.findById(id).get();
    }
}
