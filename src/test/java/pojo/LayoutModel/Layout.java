package pojo.LayoutModel;


import java.util.LinkedHashMap;
import java.util.List;
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
"total",
"x-token",
"x-query",
"modules",
"runtime"
})
@Generated("jsonschema2pojo")
public class Layout {

@JsonProperty("total")
private Integer total;
@JsonProperty("x-token")
private String xToken;
@JsonProperty("x-query")
private String xQuery;
@JsonProperty("modules")
private List<Module> modules;
@JsonProperty("runtime")
private Integer runtime;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("total")
public Integer getTotal() {
return total;
}

@JsonProperty("total")
public void setTotal(Integer total) {
this.total = total;
}

@JsonProperty("x-token")
public String getxToken() {
return xToken;
}

@JsonProperty("x-token")
public void setxToken(String xToken) {
this.xToken = xToken;
}

@JsonProperty("x-query")
public String getxQuery() {
return xQuery;
}

@JsonProperty("x-query")
public void setxQuery(String xQuery) {
this.xQuery = xQuery;
}

@JsonProperty("modules")
public List<Module> getModules() {
return modules;
}

@JsonProperty("modules")
public void setModules(List<Module> modules) {
this.modules = modules;
}

@JsonProperty("runtime")
public Integer getRuntime() {
return runtime;
}

@JsonProperty("runtime")
public void setRuntime(Integer runtime) {
this.runtime = runtime;
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