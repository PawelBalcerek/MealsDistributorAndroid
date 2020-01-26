package pl.pawbal.mealsdistributor.ui.orderproposition.add;

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

public class AddOrderPropositionFragment extends BaseFragment implements AddOrderPropositionMvpView {
    public static final String TAG = AddOrderPropositionFragment.class.toString();

    @Inject
    AddOrderPropositionMvpPresenter<AddOrderPropositionMvpView> presenter;

    public static AddOrderPropositionFragment newInstance() {
        Bundle args = new Bundle();
        AddOrderPropositionFragment fragment = new AddOrderPropositionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_order_proposition, container, false);
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
