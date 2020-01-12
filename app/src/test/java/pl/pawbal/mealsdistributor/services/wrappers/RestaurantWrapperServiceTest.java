package pl.pawbal.mealsdistributor.services.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.services.rest.RestaurantRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantWrapperServiceTest {
    @InjectMocks
    RestaurantWrapperService restaurantWrapperService;

    @Mock
    RestaurantRestService restaurantRestService;

    @Test
    void getRestaurant() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetRestaurant> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetRestaurant> single = Mockito.mock(Single.class);
        when(restaurantRestService.getRestaurant(id)).thenReturn(single);

        //when
        restaurantWrapperService.getRestaurant(id, observer);

        //then
        verify(restaurantRestService).getRestaurant(id);
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

        //when
        restaurantWrapperService.getRestaurants(observer);

        //then
        verify(restaurantRestService).getRestaurants();
        verify(single).subscribe(observer);
    }

    @Test
    void addRestaurant() {
        //given
        AddRestaurant body = new AddRestaurant();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(restaurantRestService.addRestaurant(body)).thenReturn(single);

        //when
        restaurantWrapperService.addRestaurant(body, observer);

        //then
        verify(restaurantRestService).addRestaurant(body);
        verify(single).subscribe(observer);
    }

    @Test
    void editRestaurant() {
        //given
        EditRestaurant body = new EditRestaurant();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(restaurantRestService.editRestaurant(body)).thenReturn(single);

        //when
        restaurantWrapperService.editRestaurant(body, observer);

        //then
        verify(restaurantRestService).editRestaurant(body);
        verify(single).subscribe(observer);
    }

    @Test
    void deleteRestaurant() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(restaurantRestService.deleteRestaurant(id)).thenReturn(single);

        //when
        restaurantWrapperService.deleteRestaurant(id, observer);

        //then
        verify(restaurantRestService).deleteRestaurant(id);
        verify(single).subscribe(observer);
    }
}