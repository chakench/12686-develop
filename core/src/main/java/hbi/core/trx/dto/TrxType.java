package hbi.core.trx.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.system.dto.BaseDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ldap.odm.annotations.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by chenhe on 2016/12/26.
 * 事物类型
 */
@Table(name = "HSS_SETUP_TRX_TYPE_B")
public class TrxType implements Cloneable{
    @Id
    @GeneratedValue
    private Long trxTypeId;
    @Column
    private String trxType;   //事务类型标识
    @Column
    private String trxTypeName;  //事务类型名称
    @Column
    private Long versionNumber;
    @Column
    private Long oriTrxTypeId;
    @Column
    private String statusCode;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;   //有效日期从
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;    //有效日期至
    @Column
    private Long levelNo;  //启用层级数
    @Column
    private Long sscId;
    @Column
    private Long objectVersionNumber;
    @Column
    private Long createdBy;
    @Column
    private Long lastUpdatedBy;

    public Long getTrxTypeId() {
        return trxTypeId;
    }

    public void setTrxTypeId(Long trxTypeId) {
        this.trxTypeId = trxTypeId;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public String getTrxTypeName() {
        return trxTypeName;
    }

    public void setTrxTypeName(String trxTypeName) {
        this.trxTypeName = trxTypeName;
    }

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Long getOriTrxTypeId() {
        return oriTrxTypeId;
    }

    public void setOriTrxTypeId(Long oriTrxTypeId) {
        this.oriTrxTypeId = oriTrxTypeId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public Long getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Long levelNo) {
        this.levelNo = levelNo;
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public TrxType clone()  {
        TrxType type=null;
        try {
            type= (TrxType) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public String toString() {
        return "TrxType{" +
                "trxTypeId=" + trxTypeId +
                ", trxType='" + trxType + '\'' +
                ", trxTypeName='" + trxTypeName + '\'' +
                ", versionNumber=" + versionNumber +
                ", oriTrxTypeId=" + oriTrxTypeId +
                ", statusCode='" + statusCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", levelNo=" + levelNo +
                ", sscId=" + sscId +
                ", objectVersionNumber=" + objectVersionNumber +
                '}';
    }
}
