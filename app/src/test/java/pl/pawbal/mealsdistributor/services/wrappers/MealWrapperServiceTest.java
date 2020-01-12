package pl.pawbal.mealsdistributor.services.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.services.rest.MealRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealWrapperServiceTest {
    @InjectMocks
    MealWrapperService mealWrapperService;

    @Mock
    MealRestService mealRestService;

    @Test
    void getMeal() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetMeal> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetMeal> single = Mockito.mock(Single.class);
        when(mealRestService.getMeal(id)).thenReturn(single);

        //when
        mealWrapperService.getMeal(id, observer);

        //then
        verify(mealRestService).getMeal(id);
        verify(single).subscribe(observer);
    }

    @Test
    void getMeals() {
        //given
        UUID restaurantId = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetMeals> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetMeals> single = Mockito.mock(Single.class);
        when(mealRestService.getMeals(restaurantId)).thenReturn(single);

        //when
        mealWrapperService.getMeals(restaurantId, observer);

        //then
        verify(mealRestService).getMeals(restaurantId);
        verify(single).subscribe(observer);
    }

    @Test
    void addMeal() {
        //given
        AddMeal body = new AddMeal();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(mealRestService.addMeal(body)).thenReturn(single);

        //when
        mealWrapperService.addMeal(body, observer);

        //then
        verify(mealRestService).addMeal(body);
        verify(single).subscribe(observer);
    }

    @Test
    void editMeal() {
        //given
        EditMeal body = new EditMeal();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(mealRestService.editMeal(body)).thenReturn(single);

        //when
        mealWrapperService.editMeal(body, observer);

        //then
        verify(mealRestService).editMeal(body);
        verify(single).subscribe(observer);
    }

    @Test
    void deleteMeal() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(mealRestService.deleteMeal(id)).thenReturn(single);

        //when
        mealWrapperService.deleteMeal(id, observer);

        //then
        verify(mealRestService).deleteMeal(id);
        verify(single).subscribe(observer);
    }
}