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
import pl.pawbal.mealsdistributor.data.api.service.rest.RestaurantRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantWrapperServiceTest {
    @InjectMocks
    RestaurantWrapperService restaurantWrapperService;

    @Mock
    RestaurantRestService restaurantRestService;

    @Mock
    ResponseWrapper responseWrapper;

    @Test
    void getRestaurant() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetRestaurant> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetRestaurant> single = Mockito.mock(Single.class);
        when(restaurantRestService.getRestaurant(id)).thenReturn(single);
        when(responseWrapper.wrapSingle(single)).thenReturn(single);

        //when
        restaurantWrapperService.getRestaurant(id, observer);

        //then
        verify(restaurantRestService).getRestaurant(id);
        verify(responseWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void getRestaurants() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetRestaurants> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetRestaurants> single = Mockito.mock(Single.class);
        when(restaurantRestService.getRestaurants()).thenReturn(single);
        when(responseWrapper.wrapSingle(single)).thenReturn(single);

        //when
        restaurantWrapperService.getRestaurants(observer);

        //then
        verify(restaurantRestService).getRestaurants();
        verify(responseWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void addRestaurant() {
        //given
        AddRestaurant body = new AddRestaurant();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(restaurantRestService.addRestaurant(body)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        restaurantWrapperService.addRestaurant(body, observer);

        //then
        verify(restaurantRestService).addRestaurant(body);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }

    @Test
    void editRestaurant() {
        //given
        EditRestaurant body = new EditRestaurant();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(restaurantRestService.editRestaurant(body)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        restaurantWrapperService.editRestaurant(body, observer);

        //then
        verify(restaurantRestService).editRestaurant(body);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }

    @Test
    void deleteRestaurant() {
        //given
        UUID id = UUID.randomUUID();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(restaurantRestService.deleteRestaurant(id)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        restaurantWrapperService.deleteRestaurant(id, observer);

        //then
        verify(restaurantRestService).deleteRestaurant(id);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }
}