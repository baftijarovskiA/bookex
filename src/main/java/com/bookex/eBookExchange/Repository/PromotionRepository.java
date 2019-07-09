package com.bookex.eBookExchange.Repository;

import com.bookex.eBookExchange.Model.Promotion;

import java.util.List;

public interface PromotionRepository {

    List<Promotion> getAllPromotions();

    Promotion getPromotionById(Long id);

    Promotion addNewPromotion(Promotion promotion);

    Promotion deletePromotionById(Long id);

    Promotion updatePromotionById(Long id, Promotion promotion);

    void setVisibility(int state, Long promotionId);
}
