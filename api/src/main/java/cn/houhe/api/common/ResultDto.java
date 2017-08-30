package cn.houhe.api.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Objects;
/**
 * ResultDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T05:36:23.626Z")

public class ResultDto<T>   {
  @JsonProperty("code")
  private String code = "0";

  @JsonProperty("msg")
  private String msg = "成功";

  @JsonProperty("data")
  private Object data = new HashMap<>();

  public ResultDto code(String code) {
    this.code = code;
    return this;
  }


  public ResultDto() {
  }

  public ResultDto(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ResultDto(String msg) {
    this.msg = msg;
  }

  /**
   * 响应码, \"0\"：成功，\"1\"：识别失败
   * @return code
  **/
  @ApiModelProperty(value = "响应码, \"0\"：成功，\"1\"：识别失败")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ResultDto msg(String msg) {
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

  public ResultDto data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * 返回数据
   * @return data
  **/
  @ApiModelProperty(value = "返回数据")
  public Object getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultDto resultDto = (ResultDto) o;
    return Objects.equals(this.code, resultDto.code) &&
        Objects.equals(this.msg, resultDto.msg) &&
        Objects.equals(this.data, resultDto.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, msg, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultDto {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

