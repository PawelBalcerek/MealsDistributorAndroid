package pl.pawbal.mealsdistributor.ui.action.success;

import android.os.Bundle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.factory.bundle.RestaurantBundleFactory;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsMvpView;
import pl.pawbal.mealsdistributor.ui.restaurant.edit.EditRestaurantMvpView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantSuccessHandlerTest {
    @InjectMocks
    RestaurantSuccessHandler successHandler;

    @Mock
    RestaurantBundleFactory restaurantBundleFactory;

    @Test
    void onGetRestaurantsSuccess() {
        //given
        GetRestaurants getRestaurants = new GetRestaurants();
        getRestaurants.setRestaurants(new ArrayList<Restaurant>() {{
            add(new Restaurant());
        }});
        RestaurantMvpView view = Mockito.mock(RestaurantMvpView.class);

        //when
        successHandler.onGetRestaurantsSuccess(getRestaurants, view);

        //then
        verify(view).bindRestaurantsToList(getRestaurants.getRestaurants());
        verify(view).hideLoading();
    }

    @Test
    void onAddRestaurantSuccess() {
        //given
        AddRestaurantMvpView view = Mockito.mock(AddRestaurantMvpView.class);

        //when
        successHandler.onAddRestaurantSuccess(view);

        //then
        verify(view).hideLoading();
        verify(view).goBack();
    }

    @Test
    void onGetRestaurantSuccess() {
        //given
        GetRestaurant restaurant = new GetRestaurant();
        RestaurantMvpView view = Mockito.mock(RestaurantMvpView.class);
        Bundle getRestaurant = new Bundle();
        when(restaurantBundleFactory.create(restaurant)).thenReturn(getRestaurant);

        //when
        successHandler.onGetRestaurantSuccess(restaurant, view);

        //then
        verify(view).hideLoading();
        verify(restaurantBundleFactory).create(restaurant);
        verify(view).navigateToRestaurantDetails(getRestaurant);
    }

    @Test
    void onDeleteRestaurantSuccess() {
        //given
        RestaurantDetailsMvpView view = Mockito.mock(RestaurantDetailsMvpView.class);

        //when
        successHandler.onDeleteRestaurantSuccess(view);

        //then
        verify(view).hideLoading();
        verify(view).onRestaurantDelete();
    }

    @Test
    void onEditRestaurantSuccess() {
        //given
        EditRestaurantMvpView view = Mockito.mock(EditRestaurantMvpView.class);

        //when
        successHandler.onEditRestaurantSuccess(view);

        //then
        verify(view).hideLoading();
        verify(view).goBack();
    }
}