package pojo.LayoutModel;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"filter",
"cta",
"id",
"guid",
"title",
"style",
"action",
"layoutOrder",
"imageType",
"category",
"type",
"friendlyTitle",
"isDynamic",
"items"
})
@Generated("jsonschema2pojo")
public class Module {

@JsonProperty("filter")
private Object filter;
@JsonProperty("cta")
private Object cta;
@JsonProperty("id")
private Long id;
@JsonProperty("guid")
private String guid;
@JsonProperty("title")
private String title;
@JsonProperty("style")
private Style style;
@JsonProperty("action")
private String action;
@JsonProperty("layoutOrder")
private Integer layoutOrder;
@JsonProperty("imageType")
private String imageType;
@JsonProperty("category")
private String category;
@JsonProperty("type")
private String type;
@JsonProperty("friendlyTitle")
private String friendlyTitle;
@JsonProperty("isDynamic")
private Boolean isDynamic;
@JsonProperty("items")
private Integer items;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("filter")
public Object getFilter() {
return filter;
}

@JsonProperty("filter")
public void setFilter(Object filter) {
this.filter = filter;
}

@JsonProperty("cta")
public Object getCta() {
return cta;
}

@JsonProperty("cta")
public void setCta(Object cta) {
this.cta = cta;
}

@JsonProperty("id")
public Long getId() {
return id;
}

@JsonProperty("id")
public void setId(Long id) {
this.id = id;
}

@JsonProperty("guid")
public String getGuid() {
return guid;
}

@JsonProperty("guid")
public void setGuid(String guid) {
this.guid = guid;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("style")
public Style getStyle() {
return style;
}

@JsonProperty("style")
public void setStyle(Style style) {
this.style = style;
}

@JsonProperty("action")
public String getAction() {
return action;
}

@JsonProperty("action")
public void setAction(String action) {
this.action = action;
}

@JsonProperty("layoutOrder")
public Integer getLayoutOrder() {
return layoutOrder;
}

@JsonProperty("layoutOrder")
public void setLayoutOrder(Integer layoutOrder) {
this.layoutOrder = layoutOrder;
}

@JsonProperty("imageType")
public String getImageType() {
return imageType;
}

@JsonProperty("imageType")
public void setImageType(String imageType) {
this.imageType = imageType;
}

@JsonProperty("category")
public String getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(String category) {
this.category = category;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("friendlyTitle")
public String getFriendlyTitle() {
return friendlyTitle;
}

@JsonProperty("friendlyTitle")
public void setFriendlyTitle(String friendlyTitle) {
this.friendlyTitle = friendlyTitle;
}

@JsonProperty("isDynamic")
public Boolean getIsDynamic() {
return isDynamic;
}

@JsonProperty("isDynamic")
public void setIsDynamic(Boolean isDynamic) {
this.isDynamic = isDynamic;
}

@JsonProperty("items")
public Integer getItems() {
return items;
}

@JsonProperty("items")
public void setItems(Integer items) {
this.items = items;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
