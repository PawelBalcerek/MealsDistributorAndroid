package pl.pawbal.mealsdistributor.data.models.dto.request.meal.factory;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.LocalDateTimeUtil;

public class AddMealFactory {
    private final BigDecimalFormatUtil bigDecimalFormatUtil;
    private final LocalDateTimeUtil localDateTimeUtil;

    @Inject
    public AddMealFactory(BigDecimalFormatUtil bigDecimalFormatUtil,
                          LocalDateTimeUtil localDateTimeUtil) {
        this.bigDecimalFormatUtil = bigDecimalFormatUtil;
        this.localDateTimeUtil = localDateTimeUtil;
    }

    //TODO: unit test
    public AddMeal create(String name, String description, String price,
                          String restaurantId, @Nullable Long startDate, @Nullable Long endDate) {
        AddMeal addMeal = new AddMeal();
        addMeal.setName(name);
        addMeal.setDescription(description);
        addMeal.setPrice(bigDecimalFormatUtil.format(price));
        addMeal.setRestaurantId(restaurantId);
        addMeal.setStartDate(localDateTimeUtil.format(startDate));
        addMeal.setEndDate(localDateTimeUtil.format(endDate));
        return addMeal;
    }
}
