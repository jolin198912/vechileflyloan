package cn.houhe.api.common.enums;

/**
 * Created by think on 2017/5/8.
 */
public class Constants {

    public enum DomicileTime{
        ONE("1年以下",0),
        ONE2THREE("1~3年",1),
        THREE2SEVEN("3~7年",2),
        SEVEN("7年以上",3);


        private final int value;
        private final String name;

        DomicileTime(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }


    public enum HouseType{
        OTHER("其他",0),
        TENANT("租房",1),
        RELATIVE("亲属住房",2),
        SELF_BUILDING("自建房",3),
        COMMERCIAL_HOUSE("商品房",4);


        private final int value;
        private final String name;

        HouseType(String name, int value) {
            this.name = name;
            this.value = value;
        }


        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum EducationLevel{
        OTHER("其他",0),
        HIGH_SCHOOL("高中及以下",1),
        JUNIOR("大专", 2),
        UNIVERSITY("本科",3),
        MASTER("硕士",4),
        DOCTOR("博士",5);

        private final String name;
        private final int value;

        EducationLevel(String name, int value) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum IncomeLevel{
        BELLOW_5000("5000以下",0),
        FIVE2TEN("5000~10000",1),
        TEN("10000以上", 2);

        private final String name;
        private final int value;

        IncomeLevel(String name, int value) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum InsuranceType{
        MAJOR_ILLNESS("重大疾病险",0),
        MEDICAL("医疗险",1),
        ACCIDENT("意外险", 2),
        LIFE("寿险",3);

        private final String name;
        private final int value;

        InsuranceType(String name, int value) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum YearPay {
        BELLOW_5000("5000以下",0),
        FIVE2TEN("5000~10000",1),
        TEN("10000以上", 2);
        private final String name;
        private final int value;

        YearPay(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum MarriageState{
        MARRIED("已婚",3),
        DIVORCE("离异",2),
        WID("丧偶",1),
        SIGNAL("单身",0);
        private final String name;
        private final int value;

        MarriageState(String name, int value) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum CoupleJob {
        CHILDCARE("照顾孩子",0),
        WORK("工作",1),
        INDIVIDUAL("个体户",2),
        FARMER("务农",3);
        private final String name;
        private final int value;

        CoupleJob(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum FamilyAcount {
        TWO("2人",0),
        THREE("3人",1),
        FOUR("4人",2),
        FIVE("5人",3),
        GREATERFIVE("5人以上",4);
        private final String name;
        private final int value;

        FamilyAcount(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum Duty {
        GENERAL("普通员工",0),
        LOWERMANAGER("基层管理",1),
        MIDDLEMANAGER("中层管理",2),
        HIGHMANAGER("高层管理",3);
        private final String name;
        private final int value;

        Duty(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum Relation {
        OTHER("其他",0),
        WORKMATE("同事",1),
        FRIEND("朋友",2),
        BROTHER("兄弟姐妹",3),
        COUPLE("配偶",4),
        PARENTS("父母",5);
        private final String name;
        private final int value;

        Relation(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }


    public enum CarCount {
        ONE("第一辆",0),
        TWO("第二辆",1),
        THREE("第三辆",2),
        FOUR("第四辆及以上",3);
        private final String name;
        private final int value;

        CarCount(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

}
