package pl.pawbal.mealsdistributor.data.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrders;
import pl.pawbal.mealsdistributor.data.service.rest.OrderRestService;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.SingleWrapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderWrapperServiceTest {
    @InjectMocks
    OrderWrapperService orderWrapperService;

    @Mock
    OrderRestService orderRestService;

    @Mock
    SingleWrapper singleWrapper;

    @Test
    void getOrder() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetOrder> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetOrder> single = Mockito.mock(Single.class);
        when(orderRestService.getOrder(id)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderWrapperService.getOrder(id, observer);

        //then
        verify(orderRestService).getOrder(id);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void getOrders() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetOrders> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetOrders> single = Mockito.mock(Single.class);
        when(orderRestService.getOrders()).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderWrapperService.getOrders(observer);

        //then
        verify(orderRestService).getOrders();
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void markOrdered() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(orderRestService.markOrdered(id)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderWrapperService.markOrdered(id, observer);

        //then
        verify(orderRestService).markOrdered(id);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }
}