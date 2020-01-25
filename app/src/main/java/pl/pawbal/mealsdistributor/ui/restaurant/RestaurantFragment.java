package pl.pawbal.mealsdistributor.ui.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.base.Restaurant;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.add.AddRestaurantFragment;
import pl.pawbal.mealsdistributor.ui.restaurant.details.RestaurantDetailsFragment;
import pl.pawbal.mealsdistributor.util.FragmentUtil;

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
        RestaurantListAdapter restaurantListAdapter = new RestaurantListAdapter(restaurants, this::onRestaurantViewHolderClick);
        restaurantList.setAdapter(restaurantListAdapter);
    }

    private void onRestaurantViewHolderClick(View view) {
        TextView restaurantId = view.findViewById(R.id.tv_restaurant_id);
        presenter.navigateToRestaurantDetails(restaurantId.getText().toString());
    }

    @OnClick(R.id.btn_restaurant_add)
    void navigateToAddRestaurantFragment() {
        FragmentManager fragmentManager = requireFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(AddRestaurantFragment.TAG);
        FragmentUtil.navigateToFragment(null, fragmentManager, fromStack,
                AddRestaurantFragment.newInstance(), AddRestaurantFragment.TAG);
    }

    @Override
    public void navigateToRestaurantDetails(Bundle bundle) {
        FragmentManager fragmentManager = requireFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(RestaurantDetailsFragment.TAG);
        FragmentUtil.navigateToFragment(bundle, fragmentManager, fromStack,
                RestaurantDetailsFragment.newInstance(), RestaurantDetailsFragment.TAG);
    }

    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }
}
