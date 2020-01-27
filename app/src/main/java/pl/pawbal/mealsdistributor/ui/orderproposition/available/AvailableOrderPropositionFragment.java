package pl.pawbal.mealsdistributor.ui.orderproposition.available;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;

public class AvailableOrderPropositionFragment extends BaseFragment implements AvailableOrderPropositionMvpView {
    public static final String TAG = AvailableOrderPropositionFragment.class.toString();

    @Inject
    AvailableOrderPropositionMvpPresenter<AvailableOrderPropositionMvpView> presenter;

    public static AvailableOrderPropositionFragment newInstance() {
        Bundle args = new Bundle();
        AvailableOrderPropositionFragment fragment = new AvailableOrderPropositionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_available_order_proposition, container, false);
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

    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
