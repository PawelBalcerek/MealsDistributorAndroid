package pl.pawbal.mealsdistributor.data.api.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderposition.GetOrderPositions;
import pl.pawbal.mealsdistributor.data.api.service.rest.OrderPositionRestService;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.api.service.wrapper.core.SingleWrapper;

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
        CustomSingleObserver<GetOrderPositions> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetOrderPositions> single = Mockito.mock(Single.class);
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
    void getOrderPositionsByOrderId() {
        //given
        UUID orderId = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetOrderPositions> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetOrderPositions> single = Mockito.mock(Single.class);
        when(orderPositionRestService.getOrderPositions(orderId)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPositionWrapperService.getOrderPositions(orderId, observer);

        //then
        verify(orderPositionRestService).getOrderPositions(orderId);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }
}