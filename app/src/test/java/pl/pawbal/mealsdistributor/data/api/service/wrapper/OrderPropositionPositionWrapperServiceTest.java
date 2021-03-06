package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPropositionPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomCompletableObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.ResponseWrapper;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderpropositionposition.AddOrderPropositionPosition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderpropositionposition.GetOrderPropositionPositions;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderPropositionPositionWrapperServiceTest {
    @InjectMocks
    OrderPropositionPositionWrapperService orderPropositionPositionWrapperService;

    @Mock
    OrderPropositionPositionRestService orderPropositionPositionRestService;

    @Mock
    ResponseWrapper responseWrapper;

    @Test
    void getOrderPropositionPositions() {
        //given
        UUID orderPropositionId = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetOrderPropositionPositions> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetOrderPropositionPositions> single = Mockito.mock(Single.class);
        when(orderPropositionPositionRestService.getOrderPropositionPositions(orderPropositionId)).thenReturn(single);
        when(responseWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPropositionPositionWrapperService.getOrderPropositionPositions(orderPropositionId, observer);

        //then
        verify(orderPropositionPositionRestService).getOrderPropositionPositions(orderPropositionId);
        verify(responseWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void addOrderPropositionPosition() {
        //given
        UUID orderPropositionId = UUID.randomUUID();
        AddOrderPropositionPosition body = new AddOrderPropositionPosition();
        CustomCompletableObserver observer = Mockito.mock(CustomCompletableObserver.class);
        Completable completable = Mockito.mock(Completable.class);
        when(orderPropositionPositionRestService.addOrderPropositionPosition(orderPropositionId, body)).thenReturn(completable);
        when(responseWrapper.wrapCompletable(completable)).thenReturn(completable);

        //when
        orderPropositionPositionWrapperService.addOrderPropositionPosition(orderPropositionId, body, observer);

        //then
        verify(orderPropositionPositionRestService).addOrderPropositionPosition(orderPropositionId, body);
        verify(responseWrapper).wrapCompletable(completable);
        verify(completable).subscribe(observer);
    }
}