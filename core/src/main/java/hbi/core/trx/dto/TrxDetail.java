package hbi.core.trx.dto;

import com.hand.hap.system.dto.BaseDTO;
import org.springframework.ldap.odm.annotations.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by chenhe on 2016/12/26.
 * 事物类型层次
 */
@Table(name = "HSS_SETUP_TRX_DETAIL_B")
public class TrxDetail extends BaseDTO{
    @Id
    @GeneratedValue
    private Long trxDetailId;
    @Column
    private Long trxId;
    @Column
    private String detailTrxType;
    @Column
    private String detailTrxTypeName;
    @Column
    private String gategoryCode;
    @Column
    private Long parentDetailId;
    @Column
    private String isDisplayFlag;
    @Column
    private Long sscId;
    @Column
    private Long objectVersionNumber= Long.valueOf(1);

    @Column
    private Long createdBy;
    @Column
    private Long lastUpdatedBy;

    public TrxDetail() {
    }

    public TrxDetail(Long trxId, String detailTrxType, String detailTrxTypeName, String gategoryCode, Long parentDetailId, String isDisplayFlag) {
        this.trxId = trxId;
        this.detailTrxType = detailTrxType;
        this.detailTrxTypeName = detailTrxTypeName;
        this.gategoryCode = gategoryCode;
        this.parentDetailId = parentDetailId;
        this.isDisplayFlag = isDisplayFlag;
    }

    public Long getTrxDetailId() {
        return trxDetailId;
    }

    public void setTrxDetailId(Long trxDetailId) {
        this.trxDetailId = trxDetailId;
    }

    public Long getTrxId() {
        return trxId;
    }

    public void setTrxId(Long trxId) {
        this.trxId = trxId;
    }

    public String getDetailTrxType() {
        return detailTrxType;
    }

    public void setDetailTrxType(String detailTrxType) {
        this.detailTrxType = detailTrxType;
    }

    public String getDetailTrxTypeName() {
        return detailTrxTypeName;
    }

    public void setDetailTrxTypeName(String detailTrxTypeName) {
        this.detailTrxTypeName = detailTrxTypeName;
    }

    public String getGategoryCode() {
        return gategoryCode;
    }

    public void setGategoryCode(String gategoryCode) {
        this.gategoryCode = gategoryCode;
    }

    public Long getParentDetailId() {
        return parentDetailId;
    }

    public void setParentDetailId(Long parentDetailId) {
        this.parentDetailId = parentDetailId;
    }

    public String getIsDisplayFlag() {
        return isDisplayFlag;
    }

    public void setIsDisplayFlag(String isDisplayFlag) {
        this.isDisplayFlag = isDisplayFlag;
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

    @Override
    public Long getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @Override
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String toString() {
        return "TrxDetail{" +
                "trxDetailId=" + trxDetailId +
                ", trxId=" + trxId +
                ", detailTrxType='" + detailTrxType + '\'' +
                ", detailTrxTypeName='" + detailTrxTypeName + '\'' +
                ", gategoryCode='" + gategoryCode + '\'' +
                ", parentDetailId=" + parentDetailId +
                ", isDisplayFlag='" + isDisplayFlag + '\'' +
                ", sscId=" + sscId +
                ", objectVersionNumber=" + objectVersionNumber +
                '}';
    }
}
