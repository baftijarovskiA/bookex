package com.bookex.eBookExchange.Repository.Impl;

import com.bookex.eBookExchange.Model.Promotion;
import com.bookex.eBookExchange.Repository.JpaRepository.PromotionJpaRepository;
import com.bookex.eBookExchange.Repository.PromotionRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class PromotionRepositoryImpl implements PromotionRepository {

    private PromotionJpaRepository repository;

    public PromotionRepositoryImpl(PromotionJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return repository.findAll();
    }

    @Override
    public Promotion getPromotionById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Promotion addNewPromotion(Promotion promotion) {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        promotion.setCreated_at(localTimeString);
        promotion.setUpdated_at(localTimeString);
        promotion.setDisplay(true);

        repository.save(promotion);

        return promotion;
    }

    @Override
    public Promotion deletePromotionById(Long id) {
        Optional<Promotion> promotion = repository.findById(id);
        repository.delete(promotion.get());
        return promotion.get();
    }

    @Override
    public Promotion updatePromotionById(Long id, Promotion promotion) {

        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        Promotion p = repository.findById(id).get();
        p.setUpdated_at(localTimeString);
        p.setLink(promotion.getLink());
        p.setPicture(promotion.getPicture());
        repository.save(p);
        return p;
    }

    @Override
    public void setVisibility(int state, Long promotionId) {
        Promotion promotion = repository.findById(promotionId).get();
        if (state == 1){
            promotion.setDisplay(true);
        } else if (state == 0){
            promotion.setDisplay(false);
        }
        repository.save(promotion);
    }
}
