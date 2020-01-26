package pl.pawbal.mealsdistributor.ui.meal.details;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.config.ui.FontManager;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.meal.edit.EditMealFragment;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.FragmentUtil;
import pl.pawbal.mealsdistributor.util.LocalDateTimeUtil;

public class MealDetailsFragment extends BaseFragment implements MealDetailsMvpView {
    public static final String TAG = MealDetailsFragment.class.toString();
    private GetMeal meal;

    @Inject
    MealDetailsMvpPresenter<MealDetailsMvpView> presenter;

    @BindView(R.id.tv_meal_details_icon)
    TextView drumstickBite;

    @BindView(R.id.tv_meal_details_name)
    TextView mealName;

    @BindView(R.id.tv_meal_details_price)
    TextView mealPrice;

    @BindView(R.id.tv_meal_details_description)
    TextView mealDescription;

    @BindView(R.id.tv_meal_details_start_date)
    TextView mealStartDate;

    @BindView(R.id.tv_meal_details_end_date)
    TextView mealEndDate;

    public static MealDetailsFragment newInstance() {
        Bundle args = new Bundle();
        MealDetailsFragment fragment = new MealDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_details, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            if (view != null) ButterKnife.bind(this, view);
            presenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        setUpIcons();
        presenter.getMeal(getArguments());
    }

    private void setUpIcons() {
        Typeface typeface = FontManager.getTypeface(requireContext(), FontManager.FONTAWESOME_SOLID);
        drumstickBite.setTypeface(typeface);
    }

    @Override
    public void bindMeal(GetMeal meal) {
        this.meal = meal;
        this.mealName.setText(meal.getName());
        this.mealDescription.setText(meal.getDescription());
        this.mealPrice.setText(BigDecimalFormatUtil.formatWithCurrency(meal.getPrice()));
        String mealStartDate = LocalDateTimeUtil.format(meal.getStartDate());
        this.mealStartDate.setText(mealStartDate != null ? mealStartDate : requireContext().getResources().getString(R.string.no_info));
        String mealEndDate = LocalDateTimeUtil.format(meal.getEndDate());
        this.mealEndDate.setText(mealEndDate != null ? mealEndDate : requireContext().getResources().getString(R.string.no_info));
    }

    @OnClick(R.id.btn_meal_details_edit)
    public void navigateToEditMealFragment() {
        presenter.navigateToEditMealFragment(meal);
    }

    @Override
    public void navigateToEditMealFragment(Bundle bundle) {
        FragmentManager fragmentManager = requireFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(EditMealFragment.TAG);
        FragmentUtil.navigateToFragment(bundle, fragmentManager, fromStack,
                EditMealFragment.newInstance(), EditMealFragment.TAG);
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
