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
public class Routine_json {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("records")
    @Expose
    private Integer records;
    @SerializedName("rows")
    @Expose
    private List<Row> rows = null;
    @SerializedName("totalEntry")
    @Expose
    private Integer totalEntry;
    @SerializedName("marksNotEntry")
    @Expose
    private Integer marksNotEntry;

    public Integer getPage() {
    return page;
    }

    public void setPage(Integer page) {
    this.page = page;
    }

    public Integer getTotal() {
    return total;
    }

    public void setTotal(Integer total) {
    this.total = total;
    }

    public Integer getRecords() {
    return records;
    }

    public void setRecords(Integer records) {
    this.records = records;
    }

    public List<Row> getRows() {
    return rows;
    }

    public void setRows(List<Row> rows) {
    this.rows = rows;
    }

    public Integer getTotalEntry() {
    return totalEntry;
    }

    public void setTotalEntry(Integer totalEntry) {
    this.totalEntry = totalEntry;
    }

    public Integer getMarksNotEntry() {
    return marksNotEntry;
    }

    public void setMarksNotEntry(Integer marksNotEntry) {
    this.marksNotEntry = marksNotEntry;
    }

}
