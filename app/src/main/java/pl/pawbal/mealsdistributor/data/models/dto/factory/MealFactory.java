package pl.pawbal.mealsdistributor.data.models.dto.factory;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.LocalDateTimeFormatUtil;

public class MealFactory {
    private final BigDecimalFormatUtil bigDecimalFormatUtil;
    private final LocalDateTimeFormatUtil localDateTimeFormatUtil;

    @Inject
    public MealFactory(BigDecimalFormatUtil bigDecimalFormatUtil,
                       LocalDateTimeFormatUtil localDateTimeFormatUtil) {
        this.bigDecimalFormatUtil = bigDecimalFormatUtil;
        this.localDateTimeFormatUtil = localDateTimeFormatUtil;
    }

    //TODO: unit test
    public AddMeal create(String name, String description, String price,
                          String restaurantId, @Nullable Long startDate, @Nullable Long endDate) {
        AddMeal addMeal = new AddMeal();
        addMeal.setName(name);
        addMeal.setDescription(description);
        addMeal.setPrice(bigDecimalFormatUtil.format(price));
        addMeal.setRestaurantId(restaurantId);
        addMeal.setStartDate(localDateTimeFormatUtil.format(startDate));
        addMeal.setEndDate(localDateTimeFormatUtil.format(endDate));
        return addMeal;
    }
}
