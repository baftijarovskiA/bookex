package com.bookex.eBookExchange.Api;

import com.bookex.eBookExchange.Model.Promotion;
import com.bookex.eBookExchange.Service.Impl.PromotionServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/promotion")
public class PromotionApiController {

    private PromotionServiceImpl promotionService;

    public PromotionApiController(PromotionServiceImpl promotionService) { this.promotionService = promotionService; }

    @GetMapping
    public List<Promotion> getAllPromotions(){
        return promotionService.getAllPromotions();
    }

    @RequestMapping("/{id}")
    public Promotion getPromotionById(@PathVariable("id") Long id){
        return promotionService.getPromotionById(id);
    }

    @PostMapping
    public Promotion addNewPromotion(@Valid @RequestBody Promotion promotion){
        return promotionService.addNewPromotion(promotion);
    }

    @DeleteMapping("/{id}")
    public Promotion deletePromotionById(@PathVariable("id") Long id){ return promotionService.deletePromotionById(id); }

    @PutMapping("/{id}")
    public Promotion updatePromotionById(@PathVariable("id") Long id, @Valid @RequestBody Promotion promotion){
        return promotionService.updatePromotionById(id, promotion);
    }

    @RequestMapping("/v/{state}/{promotionId}")
    public void setVisibility(@PathVariable("state") int state, @PathVariable("promotionId") Long promotionId){
        promotionService.setVisibility(state, promotionId);
    }
}
