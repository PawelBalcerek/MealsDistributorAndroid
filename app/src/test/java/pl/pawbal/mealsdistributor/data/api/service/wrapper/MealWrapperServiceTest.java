package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.api.service.rest.MealRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.AddMeal;
import pl.pawbal.mealsdistributor.data.models.dto.request.meal.EditMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealWrapperServiceTest {
    @InjectMocks
    MealWrapperService mealWrapperService;

    @Mock
    MealRestService mealRestService;

    @Mock
    ResponseWrapper responseWrapper;

    @Test
    void getMeal() {
        //given
        String id = UUID.randomUUID().toString();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetMeal> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetMeal> single = Mockito.mock(Single.class);
        when(mealRestService.getMeal(id)).thenReturn(single);
        when(responseWrapper.wrapSingle(single)).thenReturn(single);

        //when
        mealWrapperService.getMeal(id, observer);

        //then
        verify(mealRestService).getMeal(id);
        verify(responseWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void getMeals() {
        //given
        String restaurantId = UUID.randomUUID().toString();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetMeals> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetMeals> single = Mockito.mock(Single.class);
        when(mealRestService.getMeals(restaurantId)).thenReturn(single);
        when(responseWrapper.wrapSingle(single)).thenReturn(single);

        //when
        mealWrapperService.getMeals(restaurantId, observer);

        //then
        verify(mealRestService).getMeals(restaurantId);
        verify(responseWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void addMeal() {
        //given
        AddMeal body = new AddMeal();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(mealRestService.addMeal(body)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        mealWrapperService.addMeal(body, observer);

        //then
        verify(mealRestService).addMeal(body);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }

    @Test
    void editMeal() {
        //given
        EditMeal body = new EditMeal();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(mealRestService.editMeal(body)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        mealWrapperService.editMeal(body, observer);

        //then
        verify(mealRestService).editMeal(body);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }

    @Test
    void deleteMeal() {
        //given
        UUID id = UUID.randomUUID();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(mealRestService.deleteMeal(id)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        mealWrapperService.deleteMeal(id, observer);

        //then
        verify(mealRestService).deleteMeal(id);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }
}