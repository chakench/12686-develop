package hbi.core.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by chenhe on 2016/12/20.
 * 任务设置行
 */
@Table(name = "hss_task_item_line_b")
public class ItemLine {
    @Id
    @GeneratedValue
    private Long itemLineId;
    @Column
    private Long itemHeaderId;
    @Column
    private String titleText;
    @Column
    private String columnTypeCode;
    @Column
    private String columnName;
    @Column
    private Long seqNum;
    @Column
    private String valueType;
    @Column
    private Long columnLen;
    @Column
    private String valueSet;
    @Column
    private String columnFormat;
    @Column
    private String requiredFlag;
    @Column
    private String showFlag;
    @Column
    private String enabledFlag;
    @Column
    private String uniqueFlag;
    @Column
    private Long displayWidth;
    @Column
    private Long sscId;
    @Column
    private Long objectVersionNumber;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creationDate;
    @Column
    private Long createdBy;

    public Long getItemLineId() {
        return itemLineId;
    }

    public void setItemLineId(Long itemLineId) {
        this.itemLineId = itemLineId;
    }

    public Long getItemHeaderId() {
        return itemHeaderId;
    }

    public void setItemHeaderId(Long itemHeaderId) {
        this.itemHeaderId = itemHeaderId;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getColumnTypeCode() {
        return columnTypeCode;
    }

    public void setColumnTypeCode(String columnTypeCode) {
        this.columnTypeCode = columnTypeCode;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Long getColumnLen() {
        return columnLen;
    }

    public void setColumnLen(Long columnLen) {
        this.columnLen = columnLen;
    }

    public String getValueSet() {
        return valueSet;
    }

    public void setValueSet(String valueSet) {
        this.valueSet = valueSet;
    }

    public String getColumnFormat() {
        return columnFormat;
    }

    public void setColumnFormat(String columnFormat) {
        this.columnFormat = columnFormat;
    }

    public String getRequiredFlag() {
        return requiredFlag;
    }

    public void setRequiredFlag(String requiredFlag) {
        this.requiredFlag = requiredFlag;
    }

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    public String getUniqueFlag() {
        return uniqueFlag;
    }

    public void setUniqueFlag(String uniqueFlag) {
        this.uniqueFlag = uniqueFlag;
    }

    public Long getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(Long displayWidth) {
        this.displayWidth = displayWidth;
    }

    public Long getSscId() {
        return sscId;
    }

    public void setSscId(Long sscId) {
        this.sscId = sscId;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "ItemLine{" +
                "itemLineId=" + itemLineId +
                ", itemHeaderId=" + itemHeaderId +
                ", titleText='" + titleText + '\'' +
                ", columnTypeCode='" + columnTypeCode + '\'' +
                ", columnName='" + columnName + '\'' +
                ", seqNum=" + seqNum +
                ", valueType='" + valueType + '\'' +
                ", columnLen=" + columnLen +
                ", valueSet='" + valueSet + '\'' +
                ", columnFormat='" + columnFormat + '\'' +
                ", requiredFlag='" + requiredFlag + '\'' +
                ", showFlag='" + showFlag + '\'' +
                ", enabledFlag='" + enabledFlag + '\'' +
                ", uniqueFlag='" + uniqueFlag + '\'' +
                ", displayWidth=" + displayWidth +
                ", sscId=" + sscId +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                '}';
    }
}
