package pl.pawbal.mealsdistributor.ui.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;

public class RestaurantFragment extends BaseFragment implements RestaurantMvpView {
    public static final String TAG = RestaurantFragment.class.toString();

    @BindView(R.id.rv_restaurant_list)
    RecyclerView restaurantList;

    @Inject
    RestaurantMvpPresenter<RestaurantMvpView> presenter;

    public static RestaurantFragment newInstance() {
        Bundle args = new Bundle();
        RestaurantFragment fragment = new RestaurantFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            if (view != null) setUnbinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        setUpRestaurantsList();
        presenter.getRestaurants();
    }

    private void setUpRestaurantsList() {
        restaurantList.setHasFixedSize(true);
        restaurantList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void bindRestaurantsToList(List<Restaurant> restaurants) {
        RestaurantListAdapter restaurantListAdapter = new RestaurantListAdapter(restaurants);
        restaurantList.setAdapter(restaurantListAdapter);
    }

    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }
}
