package com.bookex.eBookExchange.Repository;

import com.bookex.eBookExchange.Model.Promotion;

import java.util.List;

public interface PromotionRepository {

    List<Promotion> getAllPromotions();

    Promotion getPromotionById(String id);

    Promotion addNewPromotion(Promotion promotion);

    Promotion deletePromotionById(String id);

    Promotion updatePromotionById(String id, Promotion promotion);

    void setVisibility(int state, String promotionId);
}
