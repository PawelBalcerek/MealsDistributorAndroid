package pl.pawbal.mealsdistributor.models.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Configuration {
    @Expose
    @SerializedName("key")
    private String key;

    @Expose
    @SerializedName("value")
    private String value;
}
