package cn.houhe.api.loan.web.bo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * CreditApplyInfoDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:57:34.833Z")

public class CreditApplyInfoDto {
  @JsonProperty("memId")
  private Integer memId = null;

  public CreditApplyInfoDto memId(Integer memId) {
    this.memId = memId;
    return this;
  }

   /**
   * 用户id
   * @return memId
  **/
  @ApiModelProperty(value = "用户id")
  public Integer getMemId() {
    return memId;
  }

  public void setMemId(Integer memId) {
    this.memId = memId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditApplyInfoDto apllyCreditInfoDto = (CreditApplyInfoDto) o;
    return Objects.equals(this.memId, apllyCreditInfoDto.memId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditApplyInfoDto {\n");
    
    sb.append("    memId: ").append(toIndentedString(memId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

