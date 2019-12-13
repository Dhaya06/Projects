package com.csi.rcm.prognote.widgets.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class WidgetData implements Serializable{
    @Id
    private String _id;

    private Integer created_by;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date created_on;


    private Integer edited_by;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date edited_on;

    private String row_version;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Integer getEdited_by() {
        return edited_by;
    }

    public void setEdited_by(Integer edited_by) {
        this.edited_by = edited_by;
    }

    public Date getEdited_on() {
        return edited_on;
    }

    public void setEdited_on(Date edited_on) {
        this.edited_on = edited_on;
    }

}
