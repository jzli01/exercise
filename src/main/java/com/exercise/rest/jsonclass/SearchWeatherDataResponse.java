
package com.exercise.rest.jsonclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The root schema
 * <p>
 * The root schema comprises the entire JSON document.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message",
    "cod",
    "count",
    "list"
})
public class SearchWeatherDataResponse {

    /**
     * The message schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private String message = "";
    /**
     * The cod schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("cod")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private String cod = "";
    /**
     * The count schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("count")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private Integer count = 0;
    /**
     * The list schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("list")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private List<Object> list = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The message schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * The message schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public SearchWeatherDataResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * The cod schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    /**
     * The cod schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    public SearchWeatherDataResponse withCod(String cod) {
        this.cod = cod;
        return this;
    }

    /**
     * The count schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * The count schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    public SearchWeatherDataResponse withCount(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * The list schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("list")
    public List<Object> getList() {
        return list;
    }

    /**
     * The list schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("list")
    public void setList(List<Object> list) {
        this.list = list;
    }

    public SearchWeatherDataResponse withList(List<Object> list) {
        this.list = list;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SearchWeatherDataResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(message).append(cod).append(count).append(list).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchWeatherDataResponse) == false) {
            return false;
        }
        SearchWeatherDataResponse rhs = ((SearchWeatherDataResponse) other);
        return new EqualsBuilder().append(message, rhs.message).append(cod, rhs.cod).append(count, rhs.count).append(list, rhs.list).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
