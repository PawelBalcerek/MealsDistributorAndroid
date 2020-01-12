package pl.pawbal.mealsdistributor.services.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.services.rest.OrderPositionRestService;
import pl.pawbal.mealsdistributor.services.wrappers.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.services.wrappers.core.SingleWrapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderPositionWrapperServiceTest {
    @InjectMocks
    OrderPositionWrapperService orderPositionWrapperService;

    @Mock
    OrderPositionRestService orderPositionRestService;

    @Mock
    SingleWrapper singleWrapper;

    @Test
    void getOrderPositions() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(orderPositionRestService.getOrderPositions()).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPositionWrapperService.getOrderPositions(observer);

        //then
        verify(orderPositionRestService).getOrderPositions();
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void getOrderPositionsByOrderPropositionId() {
        //given
        UUID orderPropositionId = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(orderPositionRestService.getOrderPositions(orderPropositionId)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPositionWrapperService.getOrderPositions(orderPropositionId, observer);

        //then
        verify(orderPositionRestService).getOrderPositions(orderPropositionId);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void addOrderPosition() {
        //given
        UUID orderPropositionId = UUID.randomUUID();
        Void body = null;
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(orderPositionRestService.addOrderPosition(orderPropositionId, body)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPositionWrapperService.addOrderPosition(orderPropositionId, body, observer);

        //then
        verify(orderPositionRestService).addOrderPosition(orderPropositionId, body);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

}