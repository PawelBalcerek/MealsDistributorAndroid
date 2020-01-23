package pl.pawbal.mealsdistributor.data.models.dto.factory;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;

public class RestaurantFactory {
    private final BigDecimalFormatUtil bigDecimalFormatUtil;

    @Inject
    public RestaurantFactory(BigDecimalFormatUtil bigDecimalFormatUtil) {
        this.bigDecimalFormatUtil = bigDecimalFormatUtil;
    }

    public AddRestaurant create(String name, String phoneNumber, @Nullable String minOrderCost,
                         @Nullable String deliveryCost, @Nullable String maxPaidOrderValue,
                         boolean isPyszne) {
        AddRestaurant addRestaurant = new AddRestaurant();
        addRestaurant.setName(name);
        addRestaurant.setPhoneNumber(phoneNumber);
        addRestaurant.setMinOrderCost(bigDecimalFormatUtil.format(minOrderCost));
        addRestaurant.setDeliveryCost(bigDecimalFormatUtil.format(deliveryCost));
        addRestaurant.setMaxPaidOrderValue(bigDecimalFormatUtil.format(maxPaidOrderValue));
        addRestaurant.setPyszne(isPyszne);
        return addRestaurant;
    }

    public EditRestaurant create(String id, String name, String phoneNumber, @Nullable String minOrderCost,
                                 @Nullable String deliveryCost, @Nullable String maxPaidOrderValue,
                                 boolean isPyszne) {
        EditRestaurant editRestaurant = new EditRestaurant();
        editRestaurant.setId(id);
        editRestaurant.setName(name);
        editRestaurant.setPhoneNumber(phoneNumber);
        editRestaurant.setMinOrderCost(bigDecimalFormatUtil.format(minOrderCost));
        editRestaurant.setDeliveryCost(bigDecimalFormatUtil.format(deliveryCost));
        editRestaurant.setMaxPaidOrderValue(bigDecimalFormatUtil.format(maxPaidOrderValue));
        editRestaurant.setPyszne(isPyszne);
        return editRestaurant;
    }
}
