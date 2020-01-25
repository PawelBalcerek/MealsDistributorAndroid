package pl.pawbal.mealsdistributor.ui.meal.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.data.models.dto.response.meal.GetMeal;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;
import pl.pawbal.mealsdistributor.util.LocalDateTimeFormatUtil;

public class MealDetailsFragment extends BaseFragment implements MealDetailsMvpView {
    public static final String TAG = MealDetailsFragment.class.toString();

    @Inject
    MealDetailsMvpPresenter<MealDetailsMvpView> presenter;

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
        presenter.getMeal(getArguments());
    }

    @Override
    public void bindMeal(GetMeal meal) {
        this.mealName.setText(meal.getName());
        this.mealDescription.setText(meal.getDescription());
        this.mealPrice.setText(BigDecimalFormatUtil.formatWithCurrency(meal.getPrice()));
        String mealStartDate = LocalDateTimeFormatUtil.format(meal.getStartDate());
        this.mealStartDate.setText(mealStartDate != null ? mealStartDate : requireContext().getResources().getString(R.string.no_info));
        String mealEndDate = LocalDateTimeFormatUtil.format(meal.getEndDate());
        this.mealEndDate.setText(mealEndDate != null ? mealEndDate : requireContext().getResources().getString(R.string.no_info));
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
