package com.bookex.eBookExchange.Service.Impl;

import com.bookex.eBookExchange.Model.Promotion;
import com.bookex.eBookExchange.Repository.Impl.PromotionRepositoryImpl;
import com.bookex.eBookExchange.Service.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepositoryImpl repository;

    public PromotionServiceImpl(PromotionRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return repository.getAllPromotions();
    }

    @Override
    public Promotion getPromotionById(String id) {
        return repository.getPromotionById(id);
    }

    @Override
    public Promotion addNewPromotion(Promotion promotion) {
        return repository.addNewPromotion(promotion);
    }

    @Override
    public Promotion deletePromotionById(String id) {
        return repository.deletePromotionById(id);
    }

    @Override
    public Promotion updatePromotionById(String id, Promotion promotion) {
        return repository.updatePromotionById(id,promotion);
    }

    @Override
    public void setVisibility(int state, String promotionId) {
        repository.setVisibility(state,promotionId);
    }
}
