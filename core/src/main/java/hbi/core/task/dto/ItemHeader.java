package hbi.core.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hbi.core.task.util.MappedJdbcTypes;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.JDBCType;
import java.util.Date;

/**
 * Created by chenhe on 2016/12/20.
 * 任务设置头
 */
@Table(name = "hss_task_item_header_b")
public class ItemHeader {
    @Id
    @GeneratedValue
    private Long itemHeaderId;
    @Column
    private String interfaceName;
    @Column
    private String description;
    @Column
    private String sourceSystemCode;
    @Column
    private String dataTypeCode;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    @Column
    private String frozenFlag;
    @Column
    private String enabledFlag;
    @Column
    private String validateClass;
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
    @Transient
    private String userName;
    @Transient
    private String meaning;

    public Long getItemHeaderId() {
        return itemHeaderId;
    }

    public void setItemHeaderId(Long itemHeaderId) {
        this.itemHeaderId = itemHeaderId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceSystemCode() {
        return sourceSystemCode;
    }

    public void setSourceSystemCode(String sourceSystemCode) {
        this.sourceSystemCode = sourceSystemCode;
    }

    public String getDataTypeCode() {
        return dataTypeCode;
    }

    public void setDataTypeCode(String dataTypeCode) {
        this.dataTypeCode = dataTypeCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFrozenFlag() {
        return frozenFlag;
    }

    public void setFrozenFlag(String frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getValidateClass() {
        return validateClass;
    }

    public void setValidateClass(String validateClass) {
        this.validateClass = validateClass;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "ItemHeader{" +
                "itemHeaderId=" + itemHeaderId +
                ", interfaceName='" + interfaceName + '\'' +
                ", description='" + description + '\'' +
                ", sourceSystemCode='" + sourceSystemCode + '\'' +
                ", dataTypeCode='" + dataTypeCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", frozenFlag='" + frozenFlag + '\'' +
                ", enabledFlag='" + enabledFlag + '\'' +
                ", validateClass='" + validateClass + '\'' +
                ", sscId=" + sscId +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                '}';
    }
}
