package pl.pawbal.mealsdistributor.ui.meal;

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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeals;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.meal.add.AddMealFragment;
import pl.pawbal.mealsdistributor.util.FragmentUtil;

public class MealFragment extends BaseFragment implements MealMvpView {
    public static final String TAG = MealFragment.class.toString();

    @Inject
    MealMvpPresenter<MealMvpView> presenter;

    @BindView(R.id.rv_meal_list)
    RecyclerView mealList;

    public static MealFragment newInstance() {
        Bundle args = new Bundle();
        MealFragment fragment = new MealFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal, container, false);
        ActivityComponent activityComponent = getActivityComponent();
        if (activityComponent != null) {
            activityComponent.inject(this);
            if (view != null) ButterKnife.bind(this, view);
            presenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        setUpMealList();
        presenter.getMeals(getArguments());
    }

    private void setUpMealList() {
        mealList.setHasFixedSize(true);
        mealList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void bindToMealList(GetMeals meals) {
        MealListAdapter mealListAdapter = new MealListAdapter(meals.getMeals(), this::onMealViewHolderClick);
        mealList.setAdapter(mealListAdapter);
    }

    private void onMealViewHolderClick(View view) {
        TextView mealId = view.findViewById(R.id.tv_meal_id);
        presenter.navigateToMealDetails(mealId.getText().toString());
    }

    @OnClick(R.id.btn_meal_add)
    void navigateToAddFragment() {
        FragmentManager fragmentManager = requireFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(AddMealFragment.TAG);
        FragmentUtil.navigateToFragment(getArguments(), fragmentManager, fromStack,
                AddMealFragment.newInstance(), AddMealFragment.TAG);
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
