package pl.pawbal.mealsdistributor.ui.action.success;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurants;
import pl.pawbal.mealsdistributor.ui.restaurant.RestaurantMvpView;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RestaurantSuccessHandlerTest {
    @InjectMocks
    RestaurantSuccessHandler successHandler;

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
    }

}