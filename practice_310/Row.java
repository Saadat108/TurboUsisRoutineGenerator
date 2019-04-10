/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author User
 */
public class Row {
    @SerializedName("cell")
    @Expose
    private List<String> cell = null;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("id")
    @Expose
    private Object id;

    public List<String> getCell() {
    return cell;
    }

    public void setCell(List<String> cell) {
    this.cell = cell;
    }

    public String getClass_() {
    return _class;
    }

    public void setClass_(String _class) {
    this._class = _class;
    }

    public Object getId() {
    return id;
    }

    public void setId(Object id) {
    this.id = id;
    }
}
