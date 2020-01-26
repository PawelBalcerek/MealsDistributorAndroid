package pl.pawbal.mealsdistributor.data.models.dto.request.meal.factory;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.LocalDateTimeUtil;

public class EditMealFactory {
    private final BigDecimalFormatUtil bigDecimalFormatUtil;
    private final LocalDateTimeUtil localDateTimeUtil;

    @Inject
    public EditMealFactory(BigDecimalFormatUtil bigDecimalFormatUtil,
                           LocalDateTimeUtil localDateTimeUtil) {
        this.bigDecimalFormatUtil = bigDecimalFormatUtil;
        this.localDateTimeUtil = localDateTimeUtil;
    }

    //TODO: unit test
    public EditMeal create(String id, String name, String description, String price,
                           @Nullable Long startDate, @Nullable Long endDate) {
        EditMeal editMeal = new EditMeal();
        editMeal.setId(id);
        editMeal.setName(name);
        editMeal.setDescription(description);
        editMeal.setPrice(bigDecimalFormatUtil.format(price));
        editMeal.setStartDate(localDateTimeUtil.format(startDate));
        editMeal.setEndDate(localDateTimeUtil.format(endDate));
        return editMeal;
    }
}
