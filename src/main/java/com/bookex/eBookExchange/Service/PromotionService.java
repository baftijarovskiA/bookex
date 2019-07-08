package com.bookex.eBookExchange.Service;

import com.bookex.eBookExchange.Model.Promotion;

import java.util.List;

public interface PromotionService {

    List<Promotion> getAllPromotions();

    Promotion getPromotionById(String id);

    Promotion addNewPromotion(Promotion promotion);

    Promotion deletePromotionById(String id);

    Promotion updatePromotionById(String id, Promotion promotion);

    void setVisibility(int state, String promotionId);
}
