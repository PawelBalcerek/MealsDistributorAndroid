package pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.factory;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.util.LocalDateTimeUtil;

public class AddOrderPropositionFactory {
    private final LocalDateTimeUtil localDateTimeUtil;

    @Inject
    public AddOrderPropositionFactory(LocalDateTimeUtil localDateTimeUtil) {
        this.localDateTimeUtil = localDateTimeUtil;
    }

    public AddOrderProposition create(String restaurantId, Long orderTime) {
        AddOrderProposition addOrderProposition = new AddOrderProposition();
        addOrderProposition.setRestaurantId(restaurantId);
        addOrderProposition.setOrderTime(localDateTimeUtil.of(orderTime));
        return addOrderProposition;
    }
}
