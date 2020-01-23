package pl.pawbal.mealsdistributor.data.models.dto.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.AddRestaurant;
import pl.pawbal.mealsdistributor.data.models.dto.request.restaurant.EditRestaurant;
import pl.pawbal.mealsdistributor.util.BigDecimalFormatUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantFactoryTest {
    @InjectMocks
    RestaurantFactory restaurantFactory;

    @Mock
    BigDecimalFormatUtil bigDecimalFormatUtil;

    @Test
    void createAddRestaurant() {
        //given
        String name = "name";
        String phoneNumber = "phoneNumber";
        String minOrderCost = "0.00";
        BigDecimal expectedMinOrderCost = new BigDecimal(minOrderCost);
        String deliveryCost = "0.01";
        BigDecimal expectedDeliveryCost = new BigDecimal(deliveryCost);
        String maxPaidOrderValue = "0.02";
        BigDecimal expectedMaxPaidOrderValue = new BigDecimal(maxPaidOrderValue);
        boolean isPyszne = true;
        when(bigDecimalFormatUtil.format(minOrderCost)).thenReturn(expectedMinOrderCost);
        when(bigDecimalFormatUtil.format(deliveryCost)).thenReturn(expectedDeliveryCost);
        when(bigDecimalFormatUtil.format(maxPaidOrderValue)).thenReturn(expectedMaxPaidOrderValue);

        //when
        AddRestaurant result = restaurantFactory.create(name, phoneNumber, minOrderCost, deliveryCost, maxPaidOrderValue, isPyszne);

        //then
        assertEquals(name, result.getName());
        assertEquals(phoneNumber, result.getPhoneNumber());
        assertEquals(expectedMinOrderCost, result.getMinOrderCost());
        assertEquals(expectedDeliveryCost, result.getDeliveryCost());
        assertEquals(expectedMaxPaidOrderValue, result.getMaxPaidOrderValue());
        verify(bigDecimalFormatUtil).format(minOrderCost);
        verify(bigDecimalFormatUtil).format(deliveryCost);
        verify(bigDecimalFormatUtil).format(maxPaidOrderValue);
    }

    @Test
    void createEditRestaurant() {
        //given
        String id = UUID.randomUUID().toString();
        String name = "name";
        String phoneNumber = "phoneNumber";
        String minOrderCost = "0.00";
        BigDecimal expectedMinOrderCost = new BigDecimal(minOrderCost);
        String deliveryCost = "0.01";
        BigDecimal expectedDeliveryCost = new BigDecimal(deliveryCost);
        String maxPaidOrderValue = "0.02";
        BigDecimal expectedMaxPaidOrderValue = new BigDecimal(maxPaidOrderValue);
        boolean isPyszne = true;
        when(bigDecimalFormatUtil.format(minOrderCost)).thenReturn(expectedMinOrderCost);
        when(bigDecimalFormatUtil.format(deliveryCost)).thenReturn(expectedDeliveryCost);
        when(bigDecimalFormatUtil.format(maxPaidOrderValue)).thenReturn(expectedMaxPaidOrderValue);

        //when
        EditRestaurant result = restaurantFactory.create(id, name, phoneNumber, minOrderCost, deliveryCost, maxPaidOrderValue, isPyszne);

        //then
        assertEquals(id, result.getId());
        assertEquals(name, result.getName());
        assertEquals(phoneNumber, result.getPhoneNumber());
        assertEquals(expectedMinOrderCost, result.getMinOrderCost());
        assertEquals(expectedDeliveryCost, result.getDeliveryCost());
        assertEquals(expectedMaxPaidOrderValue, result.getMaxPaidOrderValue());
        verify(bigDecimalFormatUtil).format(minOrderCost);
        verify(bigDecimalFormatUtil).format(deliveryCost);
        verify(bigDecimalFormatUtil).format(maxPaidOrderValue);
    }

}