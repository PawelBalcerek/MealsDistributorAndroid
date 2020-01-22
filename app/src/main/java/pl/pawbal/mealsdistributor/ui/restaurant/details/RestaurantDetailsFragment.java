package pl.pawbal.mealsdistributor.ui.restaurant.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.response.restaurant.GetRestaurant;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;

public class RestaurantDetailsFragment extends BaseFragment implements RestaurantDetailsMvpView {
    public static final String TAG = RestaurantDetailsFragment.class.toString();

    @Inject
    RestaurantDetailsMvpPresenter<RestaurantDetailsMvpView> presenter;

    public static RestaurantDetailsFragment newInstance() {
        Bundle args = new Bundle();
        RestaurantDetailsFragment fragment = new RestaurantDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_details, container, false);
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
        bindRestaurantDetails();
    }

    private void bindRestaurantDetails() {
        Bundle bundle = getArguments();
        presenter.bindGetRestaurant(bundle);
    }

    @Override
    public void bindRestaurantDetails(GetRestaurant restaurant) {
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
