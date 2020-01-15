package pl.pawbal.mealsdistributor.data.service.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import io.reactivex.Single;
import pl.pawbal.mealsdistributor.data.models.dto.request.orderproposition.AddOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.order.GetOrder;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetAvailableOrderPropositions;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetOrderProposition;
import pl.pawbal.mealsdistributor.data.models.dto.response.orderproposition.GetParticipatedOrderPropositions;
import pl.pawbal.mealsdistributor.data.service.rest.OrderPropositionRestService;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.CustomSingleObserver;
import pl.pawbal.mealsdistributor.data.service.wrapper.core.SingleWrapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderPropositionWrapperServiceTest {
    @InjectMocks
    OrderPropositionWrapperService orderPropositionWrapperService;

    @Mock
    OrderPropositionRestService orderPropositionRestService;

    @Mock
    SingleWrapper singleWrapper;

    @Test
    void getParticipatedOrderPropositions() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetParticipatedOrderPropositions> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetParticipatedOrderPropositions> single = Mockito.mock(Single.class);
        when(orderPropositionRestService.getParticipatedOrderPropositions()).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPropositionWrapperService.getParticipatedOrderPropositions(observer);

        //then
        verify(orderPropositionRestService).getParticipatedOrderPropositions();
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void getAvailableOrderPropositions() {
        //given
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetAvailableOrderPropositions> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetAvailableOrderPropositions> single = Mockito.mock(Single.class);
        when(orderPropositionRestService.getAvailableOrderPropositions()).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPropositionWrapperService.getAvailableOrderPropositions(observer);

        //then
        verify(orderPropositionRestService).getAvailableOrderPropositions();
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void getOrderProposition() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetOrderProposition> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetOrderProposition> single = Mockito.mock(Single.class);
        when(orderPropositionRestService.getOrderProposition(id)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPropositionWrapperService.getOrderProposition(id, observer);

        //then
        verify(orderPropositionRestService).getOrderProposition(id);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void addOrderProposition() {
        //given
        AddOrderProposition body = new AddOrderProposition();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<Void> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<Void> single = Mockito.mock(Single.class);
        when(orderPropositionRestService.addOrderProposition(body)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPropositionWrapperService.addOrderProposition(body, observer);

        //then
        verify(orderPropositionRestService).addOrderProposition(body);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }

    @Test
    void realizeOrderProposition() {
        //given
        UUID id = UUID.randomUUID();
        @SuppressWarnings("unchecked")
        CustomSingleObserver<GetOrder> observer = Mockito.mock(CustomSingleObserver.class);
        @SuppressWarnings("unchecked")
        Single<GetOrder> single = Mockito.mock(Single.class);
        when(orderPropositionRestService.realizeOrderProposition(id)).thenReturn(single);
        when(singleWrapper.wrapSingle(single)).thenReturn(single);

        //when
        orderPropositionWrapperService.realizeOrderProposition(id, observer);

        //then
        verify(orderPropositionRestService).realizeOrderProposition(id);
        verify(singleWrapper).wrapSingle(single);
        verify(single).subscribe(observer);
    }
}