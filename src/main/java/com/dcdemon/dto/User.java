package com.dcdemon.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private Integer id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private List<String> hobby;

    @JsonInclude(Include.NON_EMPTY)
    private Map<String, Object> _innerMap;

    @JsonAnySetter
    public void set_innerMap(String key, Object value) {
        if (this._innerMap == null) {
            this._innerMap = new HashMap();
        }
        this._innerMap.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> get_innerMap() {
        return this._innerMap;
    }

}
