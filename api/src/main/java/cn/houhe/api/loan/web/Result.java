package cn.houhe.api.loan.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Result
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-31T08:22:47.849Z")

public class Result {
  @JsonProperty("code")
  private Integer code = 0;

  @JsonProperty("msg")
  private String msg = "成功";

  public Result code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * 响应码, \"0\"：成功，\"1\"：识别失败
   * @return code
  **/
  @ApiModelProperty(value = "响应码, \"0\"：成功，\"1\"：识别失败")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Result msg(String msg) {
    this.msg = msg;
    return this;
  }

   /**
   * 返回消息.
   * @return msg
  **/
  @ApiModelProperty(value = "返回消息.")
  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result result = (Result) o;
    return Objects.equals(this.code, result.code) &&
        Objects.equals(this.msg, result.msg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, msg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Result {\n");

    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
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

