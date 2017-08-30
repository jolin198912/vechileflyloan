package cn.houhe.api.loan.web.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;
    /**
     * ApllyCreditDto
     */
    @javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

    public class CreditApplyIdCardDto {
        @NotNull(message = "正面照不能为空")
        @JsonProperty("front")
        private String front = null;


        @NotNull(message = "背面照不能为空")
        @JsonProperty("back")
        private String back = null;

        /*@NotNull(message = "名称不能为空")
        @JsonProperty("name")
        private String name = null;*/

        /*@NotNull(message = "身份证号不能为空")
        @JsonProperty("idCard")
        private String idCard = null;*/

        @NotNull(message = "会员id不能为空")
        @JsonProperty("memId")
        private Integer memId = null;


        @NotNull(message = "身份证头像不能为空")
        @JsonProperty("face")
        private String face  = null;

        public CreditApplyIdCardDto front(String front) {
            this.front = front;
            return this;
        }

        /**
         * 身份证人脸
         * @return face
         **/
        @ApiModelProperty(value = "身份证人脸")
        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        /**
         * 正面照
         * @return front
         **/
        @ApiModelProperty(value = "正面照")
        public String getFront() {
            return front;
        }

        public void setFront(String front) {
            this.front = front;
        }

        public CreditApplyIdCardDto back(String back) {
            this.back = back;
            return this;
        }

        /**
         * 反面照
         * @return back
         **/
        @ApiModelProperty(value = "反面照")
        public String getBack() {
            return back;
        }

        public void setBack(String back) {
            this.back = back;
        }

        /*public CreditApplyIdCardDto name(String name) {
            this.name = name;
            return this;
        }*/

        /**
         * 姓名
         * @return name
         **//*
        @ApiModelProperty(value = "姓名")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CreditApplyIdCardDto idCard(String idCard) {
            this.idCard = idCard;
            return this;
        }*/

        /**
         * 身份证
         * @return idCard
         **/
        /*@ApiModelProperty(value = "身份证")
        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }
*/
        public CreditApplyIdCardDto memId(Integer memId) {
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
        public boolean equals(java.lang.Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CreditApplyIdCardDto apllyCreditDto = (CreditApplyIdCardDto) o;
            return Objects.equals(this.front, apllyCreditDto.front) &&
                    Objects.equals(this.back, apllyCreditDto.back) &&
                    //Objects.equals(this.name, apllyCreditDto.name) &&
                    //Objects.equals(this.idCard, apllyCreditDto.idCard) &&
                    Objects.equals(this.memId, apllyCreditDto.memId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(front, back, memId);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ApllyCreditDto {\n");

            sb.append("    front: ").append(toIndentedString(front)).append("\n");
            sb.append("    back: ").append(toIndentedString(back)).append("\n");
            //sb.append("    name: ").append(toIndentedString(name)).append("\n");
            //sb.append("    idCard: ").append(toIndentedString(idCard)).append("\n");
            sb.append("    memId: ").append(toIndentedString(memId)).append("\n");
            sb.append("}");
            return sb.toString();
        }

        /**
         * Convert the given object to string with each line indented by 4 spaces
         * (except the first line).
         */
        private String toIndentedString(java.lang.Object o) {
            if (o == null) {
                return "null";
            }
            return o.toString().replace("\n", "\n    ");
        }
    }


