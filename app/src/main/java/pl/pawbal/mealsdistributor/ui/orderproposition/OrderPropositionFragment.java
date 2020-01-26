package pl.pawbal.mealsdistributor.ui.orderproposition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.pawbal.mealsdistributor.R;
import pl.pawbal.mealsdistributor.di.component.ActivityComponent;
import pl.pawbal.mealsdistributor.ui.base.BaseFragment;
import pl.pawbal.mealsdistributor.ui.orderproposition.add.AddOrderPropositionFragment;
import pl.pawbal.mealsdistributor.util.FragmentUtil;

public class OrderPropositionFragment extends BaseFragment implements OrderPropositionMvpView {
    public static final String TAG = OrderPropositionFragment.class.toString();

    @Inject
    OrderPropositionMvpPresenter<OrderPropositionMvpView> presenter;

    public static OrderPropositionFragment newInstance() {
        Bundle args = new Bundle();
        OrderPropositionFragment fragment = new OrderPropositionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_proposition, container, false);
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

    @OnClick(R.id.btn_order_proposition_add)
    public void navigateToAddOrderPropositionFragment() {
        FragmentManager fragmentManager = requireFragmentManager();
        Fragment fromStack = fragmentManager.findFragmentByTag(AddOrderPropositionFragment.TAG);
        FragmentUtil.navigateToFragment(null, fragmentManager, fromStack,
                AddOrderPropositionFragment.newInstance(), AddOrderPropositionFragment.TAG);
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
